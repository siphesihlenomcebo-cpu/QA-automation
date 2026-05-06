Feature: YouTube Video Playback

  Scenario Outline: Validate user can open YouTube via search and play a video
    Given User is on YouTube homepage
    When User searches for video "<Video>"
    And User clicks on the second video
    Then the video should start playing

    Examples:
      |        Video          |
      |  Playwright tutorial  |
