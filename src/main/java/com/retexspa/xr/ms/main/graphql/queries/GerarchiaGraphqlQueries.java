package com.retexspa.xr.ms.main.graphql.queries;

public class GerarchiaGraphqlQueries extends BaseGraphqlQuery{

    public static String search(int page){
        return String.format(
            "{\"query\":\""
            + "query { "
            + "  gerarchiaSearch(gerarchiaSearchRequest: {"
            + "    page: %s,"
            + "    limit: %s,"
            + "    sort: [{orderType: \\\"ASC\\\", orderBy: \\\"level\\\"},"
            + "           {orderType: \\\"ASC\\\", orderBy: \\\"codice\\\"}]"
            + "  }) {"
            + "    records {"
            + "      id,"
            + "      codice,"
            + "      nome,"
            + "      nodoNegozio,"
            + "      level,"
            + "      padre {"
            + "        id"
            + "      }"
            + "    }"
            + "  }"
            + "}\"}",
          page, MAX_LIMIT);
    }

    public static String count(){
        return String.format(
            "{\"query\":\""
                + "query { "
                + "  gerarchiaSearch(gerarchiaSearchRequest: {"
                + "    page: 0,"
                + "    limit: 10"
                + "  }) {"
                + "    pagination {"
                + "      count"
                + "    }"
                + "  }"
                + "}\"}");
    }

    public static String byId(String aggregatoId){
            return String.format(
                "{\"query\":\""
                    + "query { "
                    + "  gerarchiaById(id: \\\"%s\\\"){"
                    + "    id,"
                    + "    codice,"
                    + "    nome,"
                    + "    nodoNegozio,"
                    + "    level,"
                    + "    padre {"
                    + "    id }"
                    + "  }"
                    + "  }"
                    + "\"}",
                aggregatoId);
    }
    
}
