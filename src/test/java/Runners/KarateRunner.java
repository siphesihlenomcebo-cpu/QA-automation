package Runners;

import com.intuit.karate.junit5.Karate;

class KarateRunner {

    @Karate.Test
    Karate testBookingAPI() {
        return Karate.run("classpath:KarateFeature/booking.feature");
    }

        @Karate.Test
        Karate testPOST() {
        return Karate.run("classpath:KarateFeature/Post.feature");
    }

    @Karate.Test
    Karate testPUTBooking() {
        return Karate.run("classpath:KarateFeature/Put.feature");
    }

    @Karate.Test
    Karate testDeleteBooking() {
        return Karate.run("classpath:KarateFeature/Delete.feature");
    }


}
