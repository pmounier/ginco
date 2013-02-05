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
package fr.mcc.ginco.extjs.view;

import fr.mcc.ginco.beans.Thesaurus;

import java.util.ArrayList;

/**
 * Class (basically, View) intended to be used by ExtJS in JSON format,
 * implements native ExtJS features for list, such as {@link #expanded},
 * {@link #children} and {@link #id}.
 *
 * For more details about proper format of JSON follow this link :
 * http://docs.sencha.com/ext-js/4-1/#!/api/Ext.tree.Panel
 */
public class ThesaurusListTopNode {
    /**
     * Indicates if node should be expanded by default.
     */
    private boolean expanded;
    /**
     * List of all children, now only String lines.
     */
    private ArrayList<String> children;
    /**
     * Title to display for user.
     */
    private String title;
    /**
     * Service tag - not visible in UI.
     */
    private String id;

    public ThesaurusListTopNode(Thesaurus thesaurus) {
        this.expanded = false;
        children = new ArrayList<String>();
        this.title = thesaurus.getTitle();
        this.id = thesaurus.getIdentifier();
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public ArrayList<String> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<String> children) {
        this.children = children;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
