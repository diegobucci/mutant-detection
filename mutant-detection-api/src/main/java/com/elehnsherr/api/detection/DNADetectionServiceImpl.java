package com.elehnsherr.api.detection;

import com.elehnsherr.api.validation.NitrogenBaseCharsSequenceValidator;
import com.elehnsherr.api.exception.InvalidDNATableException;
import com.elehnsherr.api.exception.InvalidNitrogenBaseCharsSequenceException;
import com.elehnsherr.api.validation.DNATableValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * This class provides an implementation of DNADetectionService.
 * It exposes a concrete method to detect a Mutant based a DNA Sequence
 */
@Service
public class DNADetectionServiceImpl implements DNADetectionService {

    @Autowired
    public NitrogenBaseCharsSequenceValidator nitrogenBaseCharsSequenceValidator;

    @Autowired
    private DNATableValidator dNATableValidator;

    /**
     * Returns true if it's a Mutant DNA.
     *
     * @param dna an Array of Strings that represents a valid DNA Sequence
     * @return
     * @throws InvalidNitrogenBaseCharsSequenceException if not valid Nitrogen chars appears in the sequence
     * @throws InvalidDNATableException                  if the matrix is not a valid square matrix
     */
    @Override
    public boolean isMutantDetected(String[] dna)
            throws InvalidNitrogenBaseCharsSequenceException, InvalidDNATableException {
        if (dna == null)
            return false;

        validateDNA(dna);
        return isMutant(dna);
    }

    private void validateDNA(final String[] dna)
            throws InvalidNitrogenBaseCharsSequenceException, InvalidDNATableException {
        if (!nitrogenBaseCharsSequenceValidator.validate(dna)) {
            throw new InvalidNitrogenBaseCharsSequenceException("There is an invalid char in DNA sequence");
        }

        if (!dNATableValidator.validate(dna)) {
            throw new InvalidDNATableException("Invalid DNA Square Table");
        }
    }

    /**
     * This implementation of @{@link MutantDetectionService#isMutant(String[])} validates a DNA sequence array
     * looking if the sequence appears horizontally,vertically or diagonally
     *
     * @param dna
     * @return true if it's a Mutant DNA Matrix sequence
     */
    @Override
    public boolean isMutant(final String[] dna) {
        if (dna == null)
            return false;

        List<String> dnaMatrixRows = Arrays.asList(dna);
        long sequencesHorizontally = DNASequencePredicates.findSequenceCount(dnaMatrixRows, DNASequencePredicates.isDNAMutantSequence());
        if (sequencesHorizontally > 1)
            return true;

        String[][] dnaSequenceMatrix = createDNASequenceMatrix(dna);

        List<String> dnaMatrixColumns = findDNASequenceVertically(dnaSequenceMatrix);
        long sequencesVertically = DNASequencePredicates.findSequenceCount(dnaMatrixColumns, DNASequencePredicates.isDNAMutantSequence());
        if (sequencesVertically + sequencesHorizontally > 1)
            return true;

        List<String> dnaMatrixDiagonals = findDNASequenceDiagonally(dnaSequenceMatrix);
        long sequencesDiagonally = DNASequencePredicates.findSequenceCount(dnaMatrixDiagonals, DNASequencePredicates.isDNAMutantSequence());
        if (sequencesHorizontally + sequencesVertically + sequencesDiagonally > 1)
            return true;

        return false;
    }


    private String[][] createDNASequenceMatrix(final String[] dna) {
        String[][] dnaSequenceMatrix = IntStream.range(0, dna.length)
                .mapToObj(x -> IntStream.range(0, dna[x].length())
                        .mapToObj(y -> String.valueOf(dna[x].charAt(y)))
                        .toArray(String[]::new))
                .toArray(String[][]::new);
        return dnaSequenceMatrix;
    }

    private List<String> findDNASequenceVertically(final String[][] dnaMatrix) {
        List<String> dnaMatrixColumns = new ArrayList<>();
        for (int column = 0; column < dnaMatrix[0].length; column++) {
            StringBuffer dnaRow = new StringBuffer();
            for (int row = 0; row < dnaMatrix.length; row++) {
                dnaRow.append(dnaMatrix[row][column]);
            }
            dnaMatrixColumns.add(dnaRow.toString());
        }
        return dnaMatrixColumns;
    }

    private List<String> findDNASequenceDiagonally(final String[][] dnaMatrix) {
        List<String> dnaMatrixDiagonals = new ArrayList<>();

        dnaMatrixDiagonals.addAll(findSequencesDiagonally(dnaMatrix,true));
        dnaMatrixDiagonals.addAll(findSequencesDiagonally(dnaMatrix,false));

        return dnaMatrixDiagonals;
    }


    private List<String> findSequencesDiagonally(String[][] dnaMatrix,boolean direction){
        List<String> dnaMatrixDiagonals = new ArrayList<>();
        int maxRow = dnaMatrix.length;
        int maxColumn = dnaMatrix[0].length;

        for (int indexColumn = 0; indexColumn < maxColumn; indexColumn++) {
            for (int indexRow = 0; indexRow < dnaMatrix.length; indexRow++) {
                StringBuffer dnaDiagonal = new StringBuffer();
                int auxRow = indexRow;
                int auxColumn = indexColumn;

                if ((indexRow - 1) < 0 || (indexColumn - 1) < 0) {
                    while (auxColumn < maxColumn && auxRow < maxRow) {
                        if(direction)
                            dnaDiagonal.append(dnaMatrix[auxRow][auxColumn]);
                        else
                            dnaDiagonal.append(dnaMatrix[auxRow][maxColumn - 1 - auxColumn]);

                        auxColumn++;
                        auxRow++;
                    }
                    if (dnaDiagonal.length() >= 4)
                        dnaMatrixDiagonals.add(dnaDiagonal.toString());
                }
            }
        }
        return dnaMatrixDiagonals;
    }
}
