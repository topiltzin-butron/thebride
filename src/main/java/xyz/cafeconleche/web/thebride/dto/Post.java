package xyz.cafeconleche.web.thebride.dto;

import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table(value = "posts")
public class Post {

	@PrimaryKeyColumn(name = "post_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private UUID postId;
	@Column(value = "username")
	private String username;
	@Column(value = "body")
	private String body;

	public UUID getPostId() {
		return postId;
	}

	public void setPostId(UUID postId) {
		this.postId = postId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
