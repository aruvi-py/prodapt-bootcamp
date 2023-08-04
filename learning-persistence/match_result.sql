--query to retrieve the winner of match 1. will not work if the match is a draw.
SELECT team
FROM 
(
	SELECT teams.name AS team, count(*) AS goalcount 
	FROM goals, players, teams, matches 
	WHERE 
	players.team_id = teams.id 
	AND goals.scorer_id = players.id 
	AND (matches.away_team_id = teams.id OR matches.home_team_id = teams.id) 
	AND matches.id = 1
	GROUP BY teams.name
)
ORDER BY goalcount DESC limit 1;

