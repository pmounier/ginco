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
package fr.mcc.ginco.utils;

import java.util.ArrayList;
import java.util.List;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.exceptions.BusinessException;

public class ThesaurusTermUtils {
	
    /**
     * Returns the list of preferrefd terms from the given list
     * @param listOfTerms
     * @return
     */
    public static final List<ThesaurusTerm> getPreferedTerms(List<ThesaurusTerm> listOfTerms) {
        List<ThesaurusTerm> preferedTerms = new ArrayList<ThesaurusTerm>();
        for (ThesaurusTerm thesaurusTerm : listOfTerms) {
            if (thesaurusTerm.getPrefered()) {
                preferedTerms.add(thesaurusTerm);
            }
        }
        return preferedTerms;
    }
    
    
    /**
     * Checks 2 conditions
     * - the list must contain at least one term
     * - the list can not contains two preferred terms with the same language and the same lexical value
     * @param terms
     */
    public static boolean checkTerms(List<ThesaurusTerm> terms) {
		 List<ThesaurusTerm> preferedTerms = ThesaurusTermUtils
					.getPreferedTerms(terms);
	       
		if (preferedTerms.size() == 0) {
				throw new BusinessException("A concept must have a prefered term",
							"missing-preferred-term-for-concept");
		}
		
		List<Language> termsLangs = new ArrayList<Language>();
		for (ThesaurusTerm term:preferedTerms) {
			Language currentLang = term.getLanguage();
			if(termsLangs.contains(currentLang)) {
					throw new BusinessException("A concept must have one prefered term per language",
							"too-many-preferred-terms-for-a-language-found");
					
			}
			termsLangs.add(currentLang);			
		}		
		return true;

	}
}
