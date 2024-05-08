package com.retexspa.xr.ms.main.query.services;

import com.retexspa.xr.ms.main.core.entities.NegozioQueryDTO;
import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.NegozioListQuery;
import com.retexspa.xr.ms.main.core.responses.NegoziResponse;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.main.core.searchRequest.NegozioSearchRequest;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
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
    public Page<NegozioQueryEntity> searchQueryNegozio(NegozioSearchRequest query) {
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

        if (query.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
        }

        if (query.getCodice() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("codice")), "%" + query.getCodice().toUpperCase() + "%"));
        }

        if (query.getNome() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("nome")), "%" + query.getNome().toUpperCase() + "%"));
        }

        if (query.getDescrizione() != null) {
            specifications
                    .add((r, q, c) -> c.like(c.upper(r.get("descrizione")), "%" + query.getDescrizione().toUpperCase() + "%"));
        }
        if (query.getRagioneSociale() != null) {
            specifications.add(
                    (r, q, c) -> c.like(c.upper(r.get("ragioneSociale")), "%" + query.getRagioneSociale().toUpperCase() + "%"));
        }
        if (query.getCodiceFiscale() != null) {
            specifications.add(
                    (r, q, c) -> c.like(c.upper(r.get("codiceFiscale")), "%" + query.getCodiceFiscale().toUpperCase() + "%"));
        }
        if (query.getRegimeFiscale() != null) {
            specifications.add(
                    (r, q, c) -> c.like(c.upper(r.get("regimeFiscale")), "%" + query.getRegimeFiscale().toUpperCase() + "%"));
        }
        if (query.getMagazzino() != null) {
            specifications
                    .add((r, q, c) -> c.like(c.upper(r.get("magazzino")), "%" + query.getMagazzino().toUpperCase() + "%"));
        }
        if (query.getDifferenzialePartitaIVA() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("differenzialePartitaIVA")),
                    "%" + query.getDifferenzialePartitaIVA().toUpperCase() + "%"));
        }
        if (query.getNazionePartitaIVA() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("nazionePartitaIVA")),
                    "%" + query.getNazionePartitaIVA().toUpperCase() + "%"));
        }
        if (query.getPartitaIVA() != null) {
            specifications
                    .add((r, q, c) -> c.like(c.upper(r.get("partitaIVA")), "%" + query.getPartitaIVA().toUpperCase() + "%"));
        }
        if (query.getReaUfficio() != null) {
            specifications
                    .add((r, q, c) -> c.like(c.upper(r.get("reaUfficio")), "%" + query.getReaUfficio().toUpperCase() + "%"));
        }
        if (query.getReaNumero() != null) {
            specifications
                    .add((r, q, c) -> c.like(c.upper(r.get("reaNumero")), "%" + query.getReaNumero().toUpperCase() + "%"));
        }
        if (query.getReaCapitaleSociale() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("reaCapitaleSociale"), query.getReaCapitaleSociale()));
        }
        if (query.getReaSocioUnico() != null) {
            specifications.add(
                    (r, q, c) -> c.like(c.upper(r.get("reaSocioUnico")), "%" + query.getReaSocioUnico().toUpperCase() + "%"));
        }
        if (query.getReaLiquidazione() != null) {
            specifications.add(
                    (r, q, c) -> c.like(c.upper(r.get("reaLiquidazione")), "%" + query.getReaLiquidazione().toUpperCase() + "%"));
        }
        if (query.getCodiceDestinatarioSDI() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("codiceDestinatarioSDI")),
                    "%" + query.getCodiceDestinatarioSDI().toUpperCase() + "%"));
        }
        if (query.getSedeLegaleIndirizzo() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeLegaleIndirizzo")),
                    "%" + query.getSedeLegaleIndirizzo().toUpperCase() + "%"));
        }
        if (query.getSedeLegaleNumeroCivico() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeLegaleNumeroCivico")),
                    "%" + query.getSedeLegaleNumeroCivico().toUpperCase() + "%"));
        }
        if (query.getSedeLegaleCAP() != null) {
            specifications.add(
                    (r, q, c) -> c.like(c.upper(r.get("sedeLegaleCAP")), "%" + query.getSedeLegaleCAP().toUpperCase() + "%"));
        }
        if (query.getSedeLegaleComune() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeLegaleComune")),
                    "%" + query.getSedeLegaleComune().toUpperCase() + "%"));
        }
        if (query.getSedeLegaleProvincia() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeLegaleProvincia")),
                    "%" + query.getSedeLegaleProvincia().toUpperCase() + "%"));
        }
        if (query.getSedeLegaleNazione() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeLegaleNazione")),
                    "%" + query.getSedeLegaleNazione().toUpperCase() + "%"));
        }
        if (query.getSedeOperativaNome() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeOperativaNome")),
                    "%" + query.getSedeOperativaNome().toUpperCase() + "%"));
        }
        if (query.getSedeOperativaIndirizzo() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeOperativaIndirizzo")),
                    "%" + query.getSedeOperativaIndirizzo().toUpperCase() + "%"));
        }
        if (query.getSedeOperativaNumeroCivico() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeOperativaNumeroCivico")),
                    "%" + query.getSedeOperativaNumeroCivico().toUpperCase() + "%"));
        }
        if (query.getSedeOperativaCAP() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeOperativaCAP")),
                    "%" + query.getSedeOperativaCAP().toUpperCase() + "%"));
        }
        if (query.getSedeOperativaComune() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeOperativaComune")),
                    "%" + query.getSedeOperativaComune().toUpperCase() + "%"));
        }
        if (query.getSedeOperativaProvincia() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeOperativaProvincia")),
                    "%" + query.getSedeOperativaProvincia().toUpperCase() + "%"));
        }
        if (query.getSedeOperativaNazione() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("sedeOperativaNazione")),
                    "%" + query.getSedeOperativaNazione().toUpperCase() + "%"));
        }
        if (query.getTelefono() != null) {
            specifications
                    .add((r, q, c) -> c.like(c.upper(r.get("telefono")), "%" + query.getTelefono().toUpperCase() + "%"));
        }
        if (query.getCellulare() != null) {
            specifications
                    .add((r, q, c) -> c.like(c.upper(r.get("cellulare")), "%" + query.getCellulare().toUpperCase() + "%"));
        }
        if (query.getFax() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("fax")), "%" + query.getFax().toUpperCase() + "%"));
        }
        if (query.getEmail() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("email")), "%" + query.getEmail().toUpperCase() + "%"));
        }
        if (query.getPec() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("pec")), "%" + query.getPec().toUpperCase() + "%"));
        }
        if (query.getWeb() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("web")), "%" + query.getWeb().toUpperCase() + "%"));
        }
        if (query.getIban() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("iban")), "%" + query.getIban().toUpperCase() + "%"));
        }
        if (query.getNazioneTrasmittente() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("nazioneTrasmittente")),
                    "%" + query.getNazioneTrasmittente().toUpperCase() + "%"));
        }
        if (query.getPartitaIvaTrasmittente() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("partitaIvaTrasmittente")),
                    "%" + query.getPartitaIvaTrasmittente().toUpperCase() + "%"));
        }
        if (query.getCodiceAteco() != null) {
            specifications
                    .add((r, q, c) -> c.like(c.upper(r.get("codiceAteco")), "%" + query.getCodiceAteco().toUpperCase() + "%"));
        }
        if (query.getCanale() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("canale")), "%" + query.getCanale().toUpperCase() + "%"));
        }
        if (query.getInsegna() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("insegna")), "%" + query.getInsegna().toUpperCase() + "%"));
        }
        // ivaVentilata

        NativeQueryHelper NativeQueryHelper = new NativeQueryHelper();
        if (query.getGerarchiaId() != null) {
            String gerarchNativeQuery = NativeQueryHelper.gerarchiaNativeQuery();
            Query hierarchiaRoots = entityManager
                    .createNativeQuery(gerarchNativeQuery)
                    .setParameter("gerarchiaid", query.getGerarchiaId());
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
    public NegoziResponse searchNegozio(NegozioSearchRequest query) {

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
