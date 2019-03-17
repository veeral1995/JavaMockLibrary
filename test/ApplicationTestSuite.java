import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.library.model.business.AllBusinessTests;
import com.library.model.domain.AllDomainTests;
import com.library.model.services.AllServicesTests;


@RunWith(Suite.class)
@SuiteClasses({AllBusinessTests.class, AllServicesTests.class, AllDomainTests.class})
public class ApplicationTestSuite {

}
