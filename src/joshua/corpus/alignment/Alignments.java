package joshua.corpus.alignment;

import joshua.corpus.MatchedHierarchicalPhrases;
import joshua.corpus.Span;

public interface Alignments {
	
	int UNALIGNED = Integer.MAX_VALUE;
	
	/**
	 * This method looks up target span for the given source
	 * span
	 * 
	 * @param startSourceIndex the staring position in the
	 *                         source corpus (inclusive)
	 * @param endSourceIndex   the end position in the source
	 *                         corpus (exclusive)
	 * @return a tuple containing the min and max indices in
	 *         the target corpus, if the span is unaligned the
	 *         value will be <UNALIGNED, undefined>
	 */
	Span getAlignedTargetSpan(int startSourceIndex, int endSourceIndex);
	

	Span getAlignedTargetSpan(Span sourceSpan);
	
	/**
	 * Gets the indices of all source words aligned with 
	 * a particular location in the target corpus.
	 * 
	 * @param index Index into the target corpus
	 * @return The indices of all source words aligned with 
	 *         the given location in the target corpus.
	 */
	int[] getAlignedSourceIndices(int targetIndex);

	/**
	 * Gets the indices of all target words aligned with 
	 * a particular location in the source corpus.
	 * 
	 * @param index Index into the source corpus
	 * @return The indices of all target words aligned with 
	 *         the given location in the source corpus.
	 */
	int[] getAlignedTargetIndices(int sourceIndex);
	
	/**
	 * This method looks up source span for the given target span
	 * 
	 * @param startTargetIndex the staring position in the
	 *                         target corpus (inclusive)
	 * @param endTargetIndex   the end position in the target
	 *                         corpus (exclusive)
	 * @return a tuple containing the min and max indices in
	 *         the source corpus, if the span is unaligned the
	 *         value will be <UNALIGNED, undefined>
	 */
	Span getAlignedSourceSpan(int startTargetIndex, int endTargetIndex);
	
	/**
	 * Determines if any terminal in the source phrase aligns with the provided index into the target corpus.
	 * 
	 * @param targetIndex
	 * @param sourcePhrase
	 * @return
	 */
	boolean hasAlignedTerminal(int targetIndex, MatchedHierarchicalPhrases sourcePhrase, int sourcePhraseIndex);

	/**
	 * Gets a target span that is consistent with the provided
	 * source span, if one exists. If no consistent span exists,
	 * returns null.
	 * 
	 * @param sourceSpan
	 * @return a target span that is consistent with the provided
	 *         source span, if one exists, null otherwise
	 */
	Span getConsistentTargetSpan(Span sourceSpan);

	
	/**
	 * Gets the number of aligned sentences.
	 * 
	 * @return the number of aligned sentences
	 */
	int size();
}
