package roots.plugin.entitymanager;

import java.util.ArrayList;

import roots.entities.NameType;
import roots.entities.Names;
import roots.entities.Person;

public class PersonManager
{

	private Person person;

	public PersonManager()
	{
		this.person = new Person();
	}

	public PersonManager(Person p_person)
	{
		this.person = p_person;
	}

	public void setForenames(ArrayList<String> p_forenames)
	{
		int index = 1;
		
		NameType nametype = new NameType();
		nametype.setNametype(NameTypesENum.FORENAME.name());

		for (String forename : p_forenames)
		{
			this.setName(forename, index, nametype);
			
			index++;
		}
	}

	public void setName(String p_name, int p_index, NameType p_nametype)
	{
		Names name = new Names();
		name.setName(p_name);
		name.setNameType(p_nametype);
		name.setIndex(p_index);
		this.person.getNames().add(name);
	}

	public Person getPerson()
	{
		return person;
	}

	public void setPerson(Person person)
	{
		this.person = person;
	}
}
