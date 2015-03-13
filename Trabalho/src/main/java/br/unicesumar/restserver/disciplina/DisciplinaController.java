package br.unicesumar.restserver.disciplina;

import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplinas")
@Transactional
public class DisciplinaController {
    
    @Autowired
    private EntityManager em;
    
    @RequestMapping(value = {}, method = RequestMethod.GET)
    public List<Disciplina> getDisciplinas() {
        em.persist(new Disciplina(System.currentTimeMillis(), "aa", Integer.MIN_VALUE, Double.NaN));
        Query consulta = em.createQuery("from Disciplina");
        return consulta.getResultList();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void criarDisciplina(@RequestBody Disciplina disciplina) {
        //Disciplina novo = new Disciplina(disciplina.getId(), disciplina.getNome(), disciplina.getCargaHoraria(), disciplina.getPeso());
        //Disciplina novo = new Disciplina();
        //em.persist(novo);
        em.persist(disciplina);
    }        
    
    @RequestMapping(method = RequestMethod.PUT)
    public void alterarDisciplina(@RequestBody Disciplina disciplina) {
        //find -> persist
        //em.find(Disciplina, em);
    }        
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void excluirDisciplina(@PathVariable Long id) {
        em.createQuery("delete Disciplina where id = :id").setParameter("id", id).executeUpdate();
    }        
    
    
}
