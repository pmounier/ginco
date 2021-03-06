/**
 * Copyright or © or Copr. Ministère Français chargé de la Culture
 * et de la Communication (2013)
 * <p/>
 * contact.gincoculture_at_gouv.fr
 * <p/>
 * This software is a computer program whose purpose is to provide a thesaurus
 * management solution.
 * <p/>
 * This software is governed by the CeCILL license under French law and
 * abiding by the rules of distribution of free software. You can use,
 * modify and/ or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 * <p/>
 * As a counterpart to the access to the source code and rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty and the software's author, the holder of the
 * economic rights, and the successive licensors have only limited liability.
 * <p/>
 * In this respect, the user's attention is drawn to the risks associated
 * with loading, using, modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean that it is complicated to manipulate, and that also
 * therefore means that it is reserved for developers and experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systemsand/or
 * data to be ensured and, more generally, to use and operate it in the
 * same conditions as regards security.
 * <p/>
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL license and that you accept its terms.
 */
package fr.mcc.ginco.services;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.exceptions.BusinessException;
import fr.mcc.ginco.exceptions.TechnicalException;

import java.util.List;
import java.util.Map;

/**
 * Service used to work with {@link ThesaurusTerm} objects, contains basic
 * methods exposed to client part. For example, to get a single
 * ThesaurusTerm object, use {@link #getThesaurusTermById(String)}
 *
 * @see fr.mcc.ginco.beans
 */
public interface IThesaurusTermService {

	/**
	 * Get a single Thesaurus Term by its id
	 *
	 * @param id to search
	 * @return {@code null} if not found
	 */
	ThesaurusTerm getThesaurusTermById(String id);

	/**
	 * Get list of paginated Thesaurus Terms.
	 *
	 * @return List of Thesaurus Terms (the number given in argument), from the start index
	 */
	List<ThesaurusTerm> getPaginatedThesaurusSandoxedTermsList(Integer startIndex, Integer limit, String idThesaurus);

	/**
	 * Get list of paginated Thesaurus Preferred Terms.
	 *
	 * @return List of Thesaurus Terms (the number given in argument), from the start index
	 */
	List<ThesaurusTerm> getPaginatedThesaurusPreferredTermsList(Integer startIndex, Integer limit, String idThesaurus);


	/**
	 * Get number of Thesaurus Preferred Terms
	 *
	 * @param idThesaurus of a Thesaurus
	 * @return number of Thesaurus Sandboxed Terms for a given Thesaurus
	 */
	Long getPreferredTermsCount(String idThesaurus);


	/**
	 * Get number of Thesaurus Sandboxed Terms
	 *
	 * @param idThesaurus of a Thesaurus
	 * @return number of Thesaurus Sandboxed Terms for a given Thesaurus
	 */
	Long getSandboxedTermsCount(String idThesaurus);

	/**
	 * Get number of Thesaurus Sandboxed Validated Terms
	 *
	 * @param idThesaurus of a Thesaurus
	 * @return number of Thesaurus Validated Sandboxed Terms for a given Thesaurus
	 */
	Long getSandboxedValidatedTermsCount(String idThesaurus);


	/**
	 * Update a single Thesaurus Term Object
	 */
	ThesaurusTerm updateThesaurusTerm(ThesaurusTerm object);

	/**
	 * Delete a single Thesaurus Term Object
	 */
	ThesaurusTerm destroyThesaurusTerm(ThesaurusTerm object);


	/**
	 * @param idConcept
	 * @return This method returns all the terms that belong to a concept
	 */
	List<ThesaurusTerm> getTermsByConceptId(String idConcept);


	/**
	 * Get list of paginated Thesaurus Validated Terms.
	 *
	 * @return List of Thesaurus Terms with status validated (the number given in argument), from the start index
	 */
	List<ThesaurusTerm> getPaginatedThesaurusSandoxedValidatedTermsList(
			Integer startIndex, Integer limit, String idThesaurus);

	/**
	 * For indexing purposes.
	 *
	 * @return list of all existing terms.
	 */
	List<ThesaurusTerm> getAllTerms();

	/**
	 * For indexing purposes.
	 *
	 * @return list of all existing terms.
	 */
	List<ThesaurusTerm> getAllTerms(String thesaurusId);

	/**
	 * This service returns the identifier of a concept by the term
	 *
	 * @param lexicalValue lexical value of the term,@param
	 * @param thesaurusId  thesaurus identifier of the term,
	 * @param languageId   language identifier of the term
	 * @return identifier of a concept
	 */

	String getConceptIdByTerm(String lexicalValue, String thesaurusId, String languageId);

	/**
	 * This service returns:
	 * lexical value if the term is preferred,
	 * lexical value of preferred term if current term isn't preferred,
	 * null if the term doesn't exist
	 *
	 * @param lexicalValue lexical value of the term,
	 * @param thesaurusId  thesaurus identifier of the term,
	 * @param languageId   language identifier of the term
	 * @return preferred term
	 */

	ThesaurusTerm getPreferredTermByTerm(String lexicalValue, String thesaurusId, String languageId);

	/**
	 * This service returns true if the term is preferred,
	 * false if the term isn't preferred
	 *
	 * @param lexicalValue lexical value of the term,
	 * @param thesaurusId  thesaurus identifier of the term,
	 * @param languageId   language identifier of the term
	 * @return preferred or not preferred
	 */
	Boolean isPreferred(String lexicalValue, String thesaurusId, String languageId);

	/**
	 * This method imports sandboxed terms
	 *
	 * @param termLexicalValues list of term lexical values with language
	 * @param thesaurusId       thesaurus identifier
	 * @param defaultStatus
	 * @return
	 * @throws TechnicalException
	 */
	List<ThesaurusTerm> importSandBoxTerms(Map<String, Language> termLexicalValues, String thesaurusId, int defaultStatus);

	/**
	 * This method returns true if a similar term exist
	 *
	 * @param term
	 * @return
	 */
	Boolean isTermExist(ThesaurusTerm term);

  /**
   * Check if the Terms is used in a Concept
   * @param term list of ThesaurusTerms
   * @return
   */
  Boolean isTermAlreadyUsedInConcept(ThesaurusTerm term);
}