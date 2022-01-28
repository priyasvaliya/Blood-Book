package active_blood_receiver_request.database;

import backend.active_blood_donor_request.database.view_active_blood_donor_request.ViewActiveBloodDonorRequestQueryBuilder;
import backend.active_blood_receiver_request.database.ActiveReceiverRequestQueryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ActiveReceiverRequestQueryBuilderTest {

    @Test
    @DisplayName("Select active blood receiver request query ")
    public void selectActiveBloodReceiverRequestQuery() {
        final String STATUS_ACTIVE = "active";
        final ActiveReceiverRequestQueryBuilder activeReceiverRequestQueryBuilder = ActiveReceiverRequestQueryBuilder.getInstance();
        final String actualSelectQuery = activeReceiverRequestQueryBuilder.selectActiveBloodReceiverRequestQuery();
        final String expectedSelectQuery = "SELECT u.user_id, brr.request_id, u.first_name, u.last_name, u.date_of_birth, u.blood_group, u.email, u.contact_number, u.address_first_line, u.address_street, u.address_city, u.address_province, u.address_zip_code, u.address_country FROM user AS u, blood_receiver_request AS brr WHERE u.user_id = brr.user_id AND brr.status = \"" + STATUS_ACTIVE + "\";";
        Assertions.assertEquals(expectedSelectQuery, actualSelectQuery, "Incorrect Select Active Blood receiver Request Query.");
    }
}
