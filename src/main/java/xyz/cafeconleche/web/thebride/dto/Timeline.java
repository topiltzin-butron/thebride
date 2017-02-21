package xyz.cafeconleche.web.thebride.dto;

import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.utils.UUIDs;

@Table("timeline")
public class Timeline {

	@PrimaryKeyColumn(name="username", ordinal=1, type=PrimaryKeyType.PARTITIONED)
	private String username;
	
	@PrimaryKeyColumn(name="time", ordinal=2, type=PrimaryKeyType.CLUSTERED)
	private UUID time = UUIDs.timeBased();
	
	@Column("post_id")
	private UUID postId;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UUID getTime() {
		return time;
	}
	public void setTime(UUID time) {
		this.time = time;
	}
	public UUID getPostId() {
		return postId;
	}
	public void setPostId(UUID postId) {
		this.postId = postId;
	}
}
