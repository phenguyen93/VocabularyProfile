package de.unidue.ltl.vocabularyprofile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.POS;
import de.tudarmstadt.ukp.dkpro.core.api.metadata.type.DocumentMetaData;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.PennTree;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.chunk.Chunk;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.dependency.Dependency;

import de.unidue.ltl.escrito.core.types.GrammarProfile;
import de.unidue.ltl.escrito.core.types.VocabularyProfile;
import de.unidue.ltl.escrito.core.types.VocabularyProfile2;

public class Analyzer extends JCasAnnotator_ImplBase {

	double sumNone = 0;
	double sumA1 = 0;
	double sumA2 = 0;
	double sumB1 = 0;
	double sumB2 = 0;
	double sumC1 = 0;
	double sumC2 = 0;
	Map<Vocabulary, String> typeBasedVocab;
	
	Map<String, Object[]> data = new TreeMap<String, Object[]>();
	int i = 1;
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		/*
		 * int numberOfTokens = JCasUtil.select(aJCas, POS.class).size(); //get number
		 * of tokens without punctuation int numberOfPunc =0; Collection<Token> tokens =
		 * JCasUtil.select(aJCas, Token.class); for (Token t: tokens) {
		 * if(t.getPos().getCoarseValue()!=null) {
		 * if(t.getPos().getCoarseValue().equals("PUNCT")) { numberOfPunc +=1; } } } int
		 * numberOfTokensWithoutPunct = numberOfTokens-numberOfPunc;
		 */
		
		
		/*
		 * int typeBasedA1 = 0; int typeBasedA2 = 0; int typeBasedB1 = 0; int
		 * typeBasedB2 = 0; int typeBasedC1 = 0; int typeBasedC2 = 0;
		 * 
		 * 
		 * Collection<VocabularyProfile> vps = JCasUtil.select(aJCas,
		 * VocabularyProfile.class);
		 * 
		 * 
		 * typeBasedVocab = new HashMap<Vocabulary,String>(); for (VocabularyProfile vp
		 * : vps){ Vocabulary vo = new Vocabulary(vp.getCoveredText().toLowerCase(),
		 * vp.getName()); typeBasedVocab.put(vo, vp.getLevel()); } for(String level :
		 * typeBasedVocab.values()) { if(level.equals("A1")) {typeBasedA1 += 1; }
		 * if(level.equals("A2")) {typeBasedA2 += 1; } if(level.equals("B1"))
		 * {typeBasedB1 += 1; } if(level.equals("B2")) {typeBasedB2 += 1; }
		 * if(level.equals("C1")) {typeBasedC1+= 1; } if(level.equals("C2"))
		 * {typeBasedC2 += 1; } }
		 * 
		 * int numberOfTypeBasedToken = typeBasedVocab.size() +
		 * (numberOfTokensWithoutPunct-vps.size()); int numOfNone =
		 * numberOfTokensWithoutPunct-vps.size();
		 * System.out.println("numberOfNone :"+numOfNone);
		 * System.out.println("numberOfTypeBasedToken :"+numberOfTypeBasedToken);
		 * 
		 * 
		 * double a1 = (1.0*typeBasedA1)/numberOfTypeBasedToken; double a2 =
		 * (1.0*typeBasedA2)/numberOfTypeBasedToken; double b1 =
		 * (1.0*typeBasedB1)/numberOfTypeBasedToken; double b2 =
		 * (1.0*typeBasedB2)/numberOfTypeBasedToken; double c1 =
		 * (1.0*typeBasedC1)/numberOfTypeBasedToken; double c2 =
		 * (1.0*typeBasedC2)/numberOfTypeBasedToken; double none =
		 * (1.0*numOfNone)/numberOfTypeBasedToken;
		 * 
		 */
		
		
		/*
		 * int numberOfA1 = 0; int numberOfA2 = 0; int numberOfB1 = 0; int numberOfB2 =
		 * 0; int numberOfC1 = 0; int numberOfC2 = 0; int numberOfNo = 0;
		 */
		  Collection<VocabularyProfile> vps = JCasUtil.select(aJCas,
		  VocabularyProfile.class); for (VocabularyProfile vp : vps){
		  
		  
				
				
				/*
				 * if(vp.getLevel().equals("A1")) { numberOfA1 += 1;
				 * 
				 * }
				 */
						
						  if(vp.getLevel().equals("A2")) {
//							  numberOfA2 += 1; 
							  data.put(String.valueOf(i), new Object[] {i, vp.getCoveredText(), vp.getName()});
							  i++;	
							  }
								/*
								 * if(vp.getLevel().equals("B1")) { numberOfB1 += 1; }
								 * if(vp.getLevel().equals("B2")) { numberOfB2 += 1; }
								 * if(vp.getLevel().equals("C1")) { numberOfC1 += 1; }
								 * if(vp.getLevel().equals("C2")) { numberOfC2 += 1; }
								 * 
								 * 
								 * if(vp.getLevel().equals("No")) {
								 * 
								 * 
								 * numberOfNo +=1; }
								 */
				 
		  }
		
			/*
			 * double a1 = (1.0*numberOfA1)/vps.size(); double a2 =
			 * (1.0*numberOfA2)/vps.size(); double b1 = (1.0*numberOfB1)/vps.size(); double
			 * b2 = (1.0*numberOfB2)/vps.size(); double c1 = (1.0*numberOfC1)/vps.size();
			 * double c2 = (1.0*numberOfC2)/vps.size(); double none =
			 * (1.0*(numberOfNo))/vps.size();
			 * 
			 * data.put(String.valueOf(i), new Object[] {i,a1,a2,b1,b2,c1,c2,none}); i= i+1;
			 */
		  
				 
		  
		//create Exel File
	        XSSFWorkbook workbook = new XSSFWorkbook(); 
	         
	        //Create a blank sheet
	        XSSFSheet sheet = workbook.createSheet("A2");
	          
	        //This data needs to be written (Object[])
	        //Iterate over data and write to sheet
	        Set<String> keyset = data.keySet();
	        int rownum = 0;
	        for (String key : keyset)
	        {
	            Row row = sheet.createRow(rownum++);
	            Object [] objArr = data.get(key);
	            int cellnum = 0;
	            for (Object obj : objArr)
	            {
	               Cell cell = row.createCell(cellnum++);
	               if(obj instanceof String)
	                    cell.setCellValue((String)obj);
	                else if(obj instanceof Integer)
	                    cell.setCellValue((Integer)obj);
	                else if(obj instanceof Double)
	                    cell.setCellValue((Double)obj);
	            }
	        }
	        try
	        {
	            //Write the workbook in file system
	            FileOutputStream out = new FileOutputStream(new File("D:\\A2_ASAP1_NEW.xlsx"));
	            workbook.write(out);
	            out.close();
	            System.out.println("written successfully on disk.");
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
		  
		
		  
		  
		  
		  
		  
		  
		  
			
			/*
			 * double a1 = (1.0*numberOfA1)/numberOfTokensWithoutPunct; double a2 =
			 * (1.0*numberOfA2)/numberOfTokensWithoutPunct; double b1 =
			 * (1.0*numberOfB1)/numberOfTokensWithoutPunct; double b2 =
			 * (1.0*numberOfB2)/numberOfTokensWithoutPunct; double c1 =
			 * (1.0*numberOfC1)/numberOfTokensWithoutPunct; double c2 =
			 * (1.0*numberOfC2)/numberOfTokensWithoutPunct; double none =
			 * (1.0*(numberOfTokensWithoutPunct-numberOfA1-numberOfA2-numberOfB1-numberOfB2-
			 * numberOfC1-numberOfC2))/numberOfTokensWithoutPunct;
			 * 
			 * 
			 * sumNone += none; sumA1 +=a1; sumA2 +=a2; sumB1 +=b1; sumB2 +=b2; sumC1 +=c1;
			 * sumC2 +=c2; int anzahl = 47; System.out.println("none: "+ sumNone/anzahl);
			 * System.out.println("a1: "+ sumA1/anzahl); System.out.println("a2: "+
			 * sumA2/anzahl); System.out.println("b1: "+ sumB1/anzahl);
			 * System.out.println("b2: "+ sumB2/anzahl); System.out.println("c1: "+
			 * sumC1/anzahl); System.out.println("c2: "+ sumC2/anzahl);
			 */
			 
	}	
}
