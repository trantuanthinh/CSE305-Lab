package director;

import builder.Tenant;

public class TenantDirector {
    private Tenant tenantBuilder;

    public TenantDirector(Tenant tenantBuilder) {
        this.tenantBuilder = tenantBuilder;
    }

    public product.Tenant constructTenant() {
        return tenantBuilder.build();
    }
}
