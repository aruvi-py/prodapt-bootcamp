BEGIN TRANSACTION;
CREATE TABLE matches(
	id INTEGER PRIMARY_KEY,
	matchday TEXT,
	home_team_id INTEGER NOT NULL,
	away_team_id INTEGER NOT NULL,
	venue TEXT,
	player_of_the_match_id INTEGER NOT NULL,
	FOREIGN KEY(player_of_the_match_id) REFERENCES players(id),
	FOREIGN KEY(away_team_id) REFERENCES teams(id),
	FOREIGN KEY(home_team_id) REFERENCES teams(id)
);
COMMIT;
BEGIN TRANSACTION;
CREATE TABLE goals(
	id INTEGER PRIMARY_KEY,
	match_id INTEGER NOT NULL,
	scorer_id INTEGER NOT NULL,
	assister_id INTEGER,
	FOREIGN KEY(match_id) REFERENCES matches(id),
	FOREIGN KEY(scorer_id) REFERENCES players(id),
	FOREIGN KEY(assister_id) REFERENCES players(id)
);
COMMIT;
