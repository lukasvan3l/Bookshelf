package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;

import play.libs.Crypto;
import play.libs.Crypto.HashType;
import play.modules.siena.EnhancedModel;
import siena.DateTime;
import siena.Generator;
import siena.Id;
import utils.Utils;

/**
 * an app id that can be revoked
 */
public class ApiAuthToken extends EnhancedModel
{

	public ApiAuthToken()
	{}
	
    public static int API_KEY_LENGTH = 64;

    @Id(Generator.NONE)
    public String id;

    public User user;
    public ApiApp app;

    @DateTime
    public Date createdDate;
    @DateTime
    public Date lastseenDate;

    /**
     * removes the old tokens for this device-app combo, and creates a new one
     * also adds to every scene for this user-device combo
     * @return
     */
    public static ApiAuthToken createToken(ApiApp app, String deviceId, String deviceName, User user)
    {
        ApiAuthToken token = new ApiAuthToken();
        token.id = Crypto.passwordHash(RandomStringUtils.randomAlphanumeric(ApiAuthToken.API_KEY_LENGTH), HashType.SHA256);
        token.user = user;
        token.app = app;
        token.createdDate = new Date();
        token.save();
        return token;
    }

}
