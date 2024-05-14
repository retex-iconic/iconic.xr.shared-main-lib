package com.retexspa.xr.ms.main.query.services;

import com.retexspa.xr.ms.main.core.entities.NegozioQueryDTO;
import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.queries.NegozioListQuery;
import com.retexspa.xr.ms.main.core.responses.NegoziResponse;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.main.core.searchRequest.NegozioSearchRequest;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import com.retexspa.xr.ms.main.query.filterRequest.NegozioFilter;
import com.retexspa.xr.ms.main.query.repositories.NegozioRepository;
import com.retexspa.xr.ms.main.query.mappers.NegozioQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NegozioQueryServiceImpl implements NegozioQueryService {

    @Autowired
    private NegozioRepository negozioRepository;

    @Autowired
    NegozioQueryMapper negozioQueryMapper;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Page<NegozioQueryEntity> searchQueryNegozio(GenericSearchRequest<NegozioFilter> query) {
        NegozioFilter filter = NegozioFilter.createFilterFromMap(query.getFilter());
        List<Sort.Order> sorts = new ArrayList<>();

        if (query.getSort() != null && query.getSort().size() != 0) {
            for (BaseSort baseSort : query.getSort()) {
                switch (baseSort.getOrderBy()) {
                    case "id":
                        break;

                    case "codice":
                        break;

                    case "nome":
                        break;

                    case "descrizione":
                        break;

                    case "ragioneSociale":
                        break;

                    case "codiceFiscale":
                        break;

                    case "regimeFiscale":
                        break;

                    case "magazzino":
                        break;

                    case "differenzialePartitaIVA":
                        break;

                    case "nazionePartitaIVA":
                        break;

                    case "partitaIVA":
                        break;

                    case "reaUfficio":
                        break;

                    case "reaNumero":
                        break;

                    case "reaCapitaleSociale":
                        break;

                    case "reaSocioUnico":
                        break;

                    case "reaLiquidazione":
                        break;

                    case "codiceDestinatarioSDI":
                        break;

                    case "sedeLegaleIndirizzo":
                        break;

                    case "sedeLegaleNumeroCivico":
                        break;

                    case "sedeLegaleCAP":
                        break;

                    case "sedeLegaleComune":
                        break;

                    case "sedeLegaleProvincia":
                        break;

                    case "sedeLegaleNazione":
                        break;

                    case "sedeOperativaNome":
                        break;

                    case "sedeOperativaIndirizzo":
                        break;

                    case "sedeOperativaNumeroCivico":
                        break;

                    case "sedeOperativaCAP":
                        break;

                    case "sedeOperativaComune":
                        break;

                    case "sedeOperativaProvincia":
                        break;

                    case "sedeOperativaNazione":
                        break;

                    case "telefono":
                        break;

                    case "cellulare":
                        break;

                    case "fax":
                        break;

                    case "email":
                        break;

                    case "pec":
                        break;

                    case "web":
                        break;

                    case "iban":
                        break;

                    case "nazioneTrasmittente":
                        break;

                    case "partitaIvaTrasmittente":
                        break;

                    case "codiceAteco":
                        break;

                    case "canale":
                        break;

                    case "insegna":
                        break;

                    case "gerarchiaId":
                        break;

                    default:
                        throw new IllegalArgumentException("Order by is not correct");
                }
                sorts.add(
                        new Sort.Order(
                                baseSort.getOrderType() != null
                                        ? baseSort.getOrderType().equalsIgnoreCase("ASC")
                                        ? Sort.Direction.ASC
                                        : Sort.Direction.DESC
                                        : Sort.Direction.ASC,
                                baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "codice"));
            }
        }

        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "codice"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        List<Specification<NegozioQueryEntity>> specifications = new ArrayList<>();

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getCodice() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("codice")), "%" + filter.getCodice().toUpperCase() + "%"));
        }

        if (filter.getNome() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
        }

        if (filter.getDescrizione() != null) {
            specifications
                    .add((r, q, c) -> c.like(c.upper(r.get("descrizione")), "%" + filter.getDescrizione().toUpperCase() + "%"));
        }
        if (filter.getRagioneSociale() != null) {
            specifications.add(
                    (r, q, c) -> c.like(c.upper(r.get("ragioneSociale")), "%" + filter.getRagioneSociale().toUpperCase() + "%"));
        }
        if (filter.getCodiceFiscale() != null) {
            specifications.add(
                    (r, q, c) -> c.like(c.upper(r.get("codiceFiscale")), "%" + filter.getCodiceFiscale().toUpperCase() + "%"));
        }
        if (filter.getRegimeFiscale() != null) {
            specifications.add(
                    (r, q, c) -> c.like(c.upper(r.get("regimeFiscale")), "%" + filter.getRegimeFiscale().toUpperCase() + "%"));
        }
        if (filter.getMagazzino() != null) {
            specifications
                    .add((r, q, c) -> c.like(c.upper(r.get("magazzino")), "%" + filter.getMagazzino().toUpperCase() + "%"));
        }
        if (filter.getDifferenzialePartitaIVA() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("differenzialePartitaIVA")),
                    "%" + filter.getDifferenzialePartitaIVA().toUpperCase() + "%"));
        }
        if (filter.getNazionePartitaIVA() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("nazionePartitaIVA")),
                    "%" + filter.getNazionePartitaIVA().toUpperCase() + "%"));
        }
        if (filter.getPartitaIVA() != null) {
            specifications
                    .add((r, q, c) -> c.like(c.upper(r.get("partitaIVA")), "%" + filter.getPartitaIVA().toUpperCase() + "%"));
        }
        if (filter.getReaUfficio() != null) {
            specifications
                    .add((r, q, c) -> c.like(c.upper(r.get("reaUfficio")), "%" + filter.getReaUfficio().toUpperCase() + "%"));
        }
        if (filter.getReaNumero() != null) {
            specifications
                    .add((r, q, c) -> c.like(c.upper(r.get("reaNumero")), "%" + filter.getReaNumero().toUpperCase() + "%"));
        }
        if (filter.getReaCapitaleSociale() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("reaCapitaleSociale"), filter.getReaCapitaleSociale()));
        }
        if (filter.getReaSocioUnico() != null) {
            specifications.add(
                    (r, q, c) -> c.like(c.upper(r.get("reaSocioUnico")), "%" + filter.getReaSocioUnico().toUpperCase() + "%"));
        }
        if (filter.getReaLiquidazione() != null) {
            specifications.add(
                    (r, q, c) -> c.like(c.upper(r.get("reaLiquidazione")), "%" + filter.getReaLiquidazione().toUpperCase() + "%"));
        }
        if (filter.getCodiceDestinatarioSDI() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("codiceDestinatarioSDI")),
                    "%" + filter.getCodiceDestinatarioSDI().toUpperCase() + "%"));
        }
        if (filter.getSedeLegaleIndirizzo() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeLegaleIndirizzo")),
                    "%" + filter.getSedeLegaleIndirizzo().toUpperCase() + "%"));
        }
        if (filter.getSedeLegaleNumeroCivico() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeLegaleNumeroCivico")),
                    "%" + filter.getSedeLegaleNumeroCivico().toUpperCase() + "%"));
        }
        if (filter.getSedeLegaleCAP() != null) {
            specifications.add(
                    (r, q, c) -> c.like(c.upper(r.get("sedeLegaleCAP")), "%" + filter.getSedeLegaleCAP().toUpperCase() + "%"));
        }
        if (filter.getSedeLegaleComune() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeLegaleComune")),
                    "%" + filter.getSedeLegaleComune().toUpperCase() + "%"));
        }
        if (filter.getSedeLegaleProvincia() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeLegaleProvincia")),
                    "%" + filter.getSedeLegaleProvincia().toUpperCase() + "%"));
        }
        if (filter.getSedeLegaleNazione() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeLegaleNazione")),
                    "%" + filter.getSedeLegaleNazione().toUpperCase() + "%"));
        }
        if (filter.getSedeOperativaNome() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeOperativaNome")),
                    "%" + filter.getSedeOperativaNome().toUpperCase() + "%"));
        }
        if (filter.getSedeOperativaIndirizzo() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeOperativaIndirizzo")),
                    "%" + filter.getSedeOperativaIndirizzo().toUpperCase() + "%"));
        }
        if (filter.getSedeOperativaNumeroCivico() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeOperativaNumeroCivico")),
                    "%" + filter.getSedeOperativaNumeroCivico().toUpperCase() + "%"));
        }
        if (filter.getSedeOperativaCAP() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeOperativaCAP")),
                    "%" + filter.getSedeOperativaCAP().toUpperCase() + "%"));
        }
        if (filter.getSedeOperativaComune() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeOperativaComune")),
                    "%" + filter.getSedeOperativaComune().toUpperCase() + "%"));
        }
        if (filter.getSedeOperativaProvincia() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeOperativaProvincia")),
                    "%" + filter.getSedeOperativaProvincia().toUpperCase() + "%"));
        }
        if (filter.getSedeOperativaNazione() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeOperativaNazione")),
                    "%" + filter.getSedeOperativaNazione().toUpperCase() + "%"));
        }
        if (filter.getTelefono() != null) {
            specifications
                    .add((r, q, c) -> c.like(c.upper(r.get("telefono")), "%" + filter.getTelefono().toUpperCase() + "%"));
        }
        if (filter.getCellulare() != null) {
            specifications
                    .add((r, q, c) -> c.like(c.upper(r.get("cellulare")), "%" + filter.getCellulare().toUpperCase() + "%"));
        }
        if (filter.getFax() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("fax")), "%" + filter.getFax().toUpperCase() + "%"));
        }
        if (filter.getEmail() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("email")), "%" + filter.getEmail().toUpperCase() + "%"));
        }
        if (filter.getPec() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("pec")), "%" + filter.getPec().toUpperCase() + "%"));
        }
        if (filter.getWeb() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("web")), "%" + filter.getWeb().toUpperCase() + "%"));
        }
        if (filter.getIban() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("iban")), "%" + filter.getIban().toUpperCase() + "%"));
        }
        if (filter.getNazioneTrasmittente() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("nazioneTrasmittente")),
                    "%" + filter.getNazioneTrasmittente().toUpperCase() + "%"));
        }
        if (filter.getPartitaIvaTrasmittente() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("partitaIvaTrasmittente")),
                    "%" + filter.getPartitaIvaTrasmittente().toUpperCase() + "%"));
        }
        if (filter.getCodiceAteco() != null) {
            specifications
                    .add((r, q, c) -> c.like(c.upper(r.get("codiceAteco")), "%" + filter.getCodiceAteco().toUpperCase() + "%"));
        }
        if (filter.getCanale() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("canale")), "%" + filter.getCanale().toUpperCase() + "%"));
        }
        if (filter.getInsegna() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("insegna")), "%" + filter.getInsegna().toUpperCase() + "%"));
        }
        // ivaVentilata

        NativeQueryHelper NativeQueryHelper = new NativeQueryHelper();
        if (filter.getGerarchiaId() != null) {
            String gerarchNativeQuery = NativeQueryHelper.gerarchiaNativeQuery();
            Query hierarchiaRoots = entityManager
                    .createNativeQuery(gerarchNativeQuery)
                    .setParameter("gerarchiaid", filter.getGerarchiaId());
            List<String> hierarchiaRootsIds = hierarchiaRoots.getResultList();

            specifications.add(
                    (root, criteriaQuery, criteriaBuilder) -> {
                        // Define the subquery
                        Subquery<NegozioQueryEntity> subquery = criteriaQuery.subquery(NegozioQueryEntity.class);
                        Root<NegozioQueryEntity> subRoot = subquery.from(NegozioQueryEntity.class);

                        subquery.select(subRoot);
                        subquery.where(
                                criteriaBuilder.and(
                                        criteriaBuilder.equal(subRoot.get("padre").get("id"), root.get("id")),
                                        subRoot.get("gerarchia").get("id").in(hierarchiaRootsIds)));
                        // Integrate the subquery into the main query using criteriaBuilder
                        return criteriaBuilder.and(
                                criteriaBuilder.not(criteriaBuilder.exists(subquery)),
                                root.get("gerarchia").get("id").in(hierarchiaRootsIds));
                    });
        }

        Specification<NegozioQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

        Page<NegozioQueryEntity> page = this.negozioRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public NegoziResponse searchNegozio(GenericSearchRequest<NegozioFilter> query) {

        NegoziResponse negozioResponse = new NegoziResponse();
        Page<NegozioQueryEntity> page = searchQueryNegozio(query);
        List<NegozioQueryDTO> list = page.getContent().stream()
                .map(entity -> negozioQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        negozioResponse.setRecords(list);

        negozioResponse.setPagination(Pagination.buildPagination(page));
        return negozioResponse;
    }

    @Override
    public NegoziResponse listNegozio(NegozioListQuery query) {
        NegoziResponse negoziResponse = new NegoziResponse();
        Page<NegozioQueryEntity> page = this.negozioRepository.findAll(PageRequest.of(query.getPage(), query.getLimit()));
        List<NegozioQueryDTO> list = page.getContent().stream()
                .map(entity -> negozioQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        negoziResponse.setRecords(list);
        negoziResponse.setPagination(Pagination.buildPagination(page));
        return negoziResponse;
    }



}
