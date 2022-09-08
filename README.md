# Derby
A football (soccer) match making application made using Android (Java and XML), SQLite. Final year project for undergrad.

### Features:
* Users can register themselves and add players to their teams, prior to the match-making process.
* Users can add the following preferences:
  1. Location (where all can they intend to play)
  2. Timing (Time most suitable for their team to play)
  3. Days (Days of the week they intend to play)
  4. Team-size (based on the size of the user;s team, the opponent of similar size will be matched. For example a team of 5 can play with another team of 5 and so on).
  5. Team rating (The more they play, the more this score is increased. Penalties are added for no-show).
* The proprietary algorithm asynchronously matches the user's team with another team after compyuting the best fit according to the preferences of the opponent teams. The algorithm was also optimised to first filter out the teams that were thr closest, since location was identified as the most important attribute. 
* Upon finding several matches the users were notified. After they choose to challenge an opponent, the opponent is notified and can choose to accept their challenge.
