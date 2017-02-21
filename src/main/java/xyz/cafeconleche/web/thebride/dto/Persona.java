package xyz.cafeconleche.web.thebride.dto;

import java.util.Date;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table(value="characters")
public class Persona {

	@PrimaryKeyColumn(name="id", ordinal=1, type=PrimaryKeyType.PARTITIONED)
	private UUID id;
	@PrimaryKeyColumn(name="name", ordinal=2, type=PrimaryKeyType.CLUSTERED)
	private String name;
	@PrimaryKeyColumn(name="creation_time", ordinal=3, type=PrimaryKeyType.CLUSTERED)
	private Date creationTime;
	@Column(value="code_name")
	private String codeName;
	@Column(value="actor_name")
	private String actorName;
	@Column(value="weapon_of_choice")
	private String weaponOfChoice;
	@Column(value="group")
	private String group;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getWeaponOfChoice() {
		return weaponOfChoice;
	}

	public void setWeaponOfChoice(String weaponOfChoice) {
		this.weaponOfChoice = weaponOfChoice;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(super.toString());
		sb.append("id: ").append(id);
		sb.append(", name: ").append(name);
		sb.append(", creationTime: ").append(creationTime);
		sb.append(", codeName: ").append(codeName);
		sb.append(", actorName: ").append(actorName);
		sb.append(", weaponOfChoice: ").append(weaponOfChoice);
		sb.append(", group: ").append(group);
		return sb.toString();
	}

}
