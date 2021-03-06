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
package fr.mcc.ginco.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import fr.mcc.ginco.beans.CustomTermAttributeType;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.dao.ICustomTermAttributeTypeDAO;
import fr.mcc.ginco.exceptions.BusinessException;

/**
 *
 */
@Repository
public class CustomTermAttributeTypeDAO extends
		GenericHibernateDAO<CustomTermAttributeType, Integer> implements
		ICustomTermAttributeTypeDAO {

	@Override
	public List<CustomTermAttributeType> getAttributesByThesaurus(
			Thesaurus thesaurus) {
		Criteria criteria = getCurrentSession().createCriteria(
				CustomTermAttributeType.class).add(
				Restrictions.eq("thesaurus.identifier",
						thesaurus.getIdentifier())
		);
		return (List<CustomTermAttributeType>) criteria.list();
	}

	public CustomTermAttributeTypeDAO() {
		super(CustomTermAttributeType.class);
	}

	@Override
	public CustomTermAttributeType getAttributeByValue(Thesaurus thesaurus,
	                                                   String value) {
		Criteria criteria = getCurrentSession().createCriteria(CustomTermAttributeType.class)
				.add(Restrictions.eq("thesaurus.identifier", thesaurus.getIdentifier()))
				.add(Restrictions.eq("value", value));
		List objList = criteria.list();
		if (objList.size() > 0) {
			return (CustomTermAttributeType) objList.get(0);
		}
		return null;
	}

	@Override
	public CustomTermAttributeType getAttributeByCode(Thesaurus thesaurus,
	                                                  String code) {
		Criteria criteria = getCurrentSession()
				.createCriteria(CustomTermAttributeType.class)
				.add(Restrictions.eq("thesaurus.identifier",
						thesaurus.getIdentifier()))
				.add(Restrictions.eq("code", code));
		List objList = criteria.list();
		if (objList.size() > 0) {
			return (CustomTermAttributeType) objList.get(0);
		}
		return null;
	}

	@Override
	public CustomTermAttributeType update(CustomTermAttributeType termAttributeType) {
		getCurrentSession().setFlushMode(FlushMode.MANUAL);
		CustomTermAttributeType existingAttrByCode = this.getAttributeByCode(termAttributeType.getThesaurus(), termAttributeType.getCode());
		CustomTermAttributeType existingAttrByValue = this.getAttributeByValue(termAttributeType.getThesaurus(), termAttributeType.getValue());
		boolean isUniqueCode = true;
		boolean isUniqueValue = true;
		if (existingAttrByCode != null && existingAttrByCode.getIdentifier() != termAttributeType.getIdentifier()) {
			isUniqueCode = false;
		}
		if (existingAttrByValue != null && existingAttrByValue.getIdentifier() != termAttributeType.getIdentifier()) {
			isUniqueValue = false;
		}
		if (isUniqueValue && isUniqueCode) {
			getCurrentSession().saveOrUpdate(termAttributeType);
			getCurrentSession().flush();
		} else {
			if (!isUniqueValue) {
				throw new BusinessException(
						"Already existing custom attribute with value: "
								+ termAttributeType.getValue(),
						"already-existing-custom-attribute-value",
						new Object[]{ termAttributeType.getValue() }
				);
			} else {
				throw new BusinessException(
						"Already existing custom attribute with code: "
								+ termAttributeType.getCode(),
						"already-existing-custom-attribute-code",
						new Object[]{ termAttributeType.getCode() }
				);
			}

		}
		return termAttributeType;
	}
}