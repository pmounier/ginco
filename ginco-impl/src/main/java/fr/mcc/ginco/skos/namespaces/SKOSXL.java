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
package fr.mcc.ginco.skos.namespaces;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * SKOS vocabulary class for namespace http://www.w3.org/2008/05/skos-xl#
 */

public final class SKOSXL {

	private SKOSXL() {
	}

	private static final String URI = "http://www.w3.org/2008/05/skos-xl#";

	/**
	 * returns the URI for this schema
	 *
	 * @return the URI for this schema
	 */
	public static String getURI() {
		return URI;
	}

	private static Model m = ModelFactory.createDefaultModel();

	/**
	 * prefLabel property
	 */
	public static final Property PREF_LABEL = m.createProperty(URI
			+ "prefLabel");


	/**
	 * custom concept attribute resource
	 */
	public static final Resource PREF_LABEL_RES = m
			.createResource(URI + "prefLabel");

	/**
	 * altLabel property
	 */
	public static final Property ALT_LABEL = m.createProperty(URI + "altLabel");

	/**
	 * hiddenLabel property
	 */
	public static final Property HIDDEN_LABEL = m.createProperty(URI
			+ "hiddenLabel");

	public static final Property LITERAL_FORM = m.createProperty(URI
			+ "literalForm");


}