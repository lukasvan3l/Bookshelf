package models;

import java.util.List;

import play.modules.siena.EnhancedModel;

import siena.Generator;
import siena.Id;

/**
 * an app id that can be revoked
 */
public class ApiApp extends EnhancedModel
{
    @Id(Generator.NONE)
    public String id;

    public String name;
}
