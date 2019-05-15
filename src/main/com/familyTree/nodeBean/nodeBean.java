package main.com.familyTree.nodeBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import main.com.familyTree.marraige.marriage;
import main.com.familyTree.marraige.marriageAppServiceImpl;
import main.com.familyTree.nodes.node;
import main.com.familyTree.nodes.nodeAppServiceImpl;


@ManagedBean(name = "nodeBean")
@SessionScoped
public class nodeBean  {
	
	/**
	 * 
	 */
	/**
	 * 
	 */
	

	@ManagedProperty(value = "#{nodeFacadeImpl}")
	private nodeAppServiceImpl nodeDataFacede; 
	
	@ManagedProperty(value = "#{marriageFacadeImpl}")
	private marriageAppServiceImpl marriageDataFacede; 
	
	
	private List<node> listOfAllNodes;
	private List<String> listOfAllNames;


	 private String name;
	 private String fatherName;
	 private String grandName;
	 private String familyName;
	
	 private node selectedNode;
	 private List<node>listOfBrothersAndSisters;
	 private List<node>listOfBrothersAndSistersOfGrand;
	 
	 private List<marriage> grandMarriage;
	 private List<marriage> fatherMarriage;
	 
	@PostConstruct
	public void init() {
		refresh();
		selectedNode=new node();
	}
	
	public void refresh(){
		listOfAllNodes=nodeDataFacede.getAll();
		listOfAllNames=new ArrayList<String>();
		for(int i=0;i<listOfAllNodes.size();i++) {
			listOfAllNames.add(listOfAllNodes.get(i).getFirstName());
		}
	}

	public void selectNode() {
		
		selectedNode=nodeDataFacede.getByNameAndFatherAndGrandAndFamily(name, fatherName, grandName,familyName);
		if(selectedNode!=null) {
			grandMarriage=marriageDataFacede.getWomanMarriedManWithId(selectedNode.getGrandPaId().getId());
			fatherMarriage=marriageDataFacede.getWomanMarriedManWithId(selectedNode.getFatherId().getId());
			listOfBrothersAndSisters=nodeDataFacede.getSonsOfParent(selectedNode.getFatherId().getId());
			listOfBrothersAndSistersOfGrand=nodeDataFacede.getSonsOfParent(selectedNode.getGrandPaId().getId());
		}
		
		for(int i=0;i<listOfBrothersAndSistersOfGrand.size();i++) {
			if(listOfBrothersAndSistersOfGrand.get(i).getFirstName().equals(selectedNode.getFatherId().getFirstName())) {
				listOfBrothersAndSistersOfGrand.remove(i);
			}
			
		}
		System.out.println("Dakrory: "+listOfBrothersAndSisters.size());
	}
	
	public List<String> completeText(String query){
		
		return listOfAllNames;
	}
	
	
	public nodeAppServiceImpl getNodeDataFacede() {
		return nodeDataFacede;
	}

	public void setNodeDataFacede(nodeAppServiceImpl nodeDataFacede) {
		this.nodeDataFacede = nodeDataFacede;
	}

	

	public List<node> getListOfAllNodes() {
		return listOfAllNodes;
	}

	public void setListOfAllNodes(List<node> listOfAllNodes) {
		this.listOfAllNodes = listOfAllNodes;
	}

	public List<String> getListOfAllNames() {
		return listOfAllNames;
	}

	public void setListOfAllNames(List<String> listOfAllNames) {
		this.listOfAllNames = listOfAllNames;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getGrandName() {
		return grandName;
	}

	public void setGrandName(String grandName) {
		this.grandName = grandName;
	}

	
	
	public node getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(node selectedNode) {
		this.selectedNode = selectedNode;
	}

	
	public List<node> getListOfBrothersAndSisters() {
		return listOfBrothersAndSisters;
	}

	public void setListOfBrothersAndSisters(List<node> listOfBrothersAndSisters) {
		this.listOfBrothersAndSisters = listOfBrothersAndSisters;
	}

	public List<node> getListOfBrothersAndSistersOfGrand() {
		return listOfBrothersAndSistersOfGrand;
	}

	public void setListOfBrothersAndSistersOfGrand(List<node> listOfBrothersAndSistersOfGrand) {
		this.listOfBrothersAndSistersOfGrand = listOfBrothersAndSistersOfGrand;
	}

	
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public marriageAppServiceImpl getMarriageDataFacede() {
		return marriageDataFacede;
	}

	public void setMarriageDataFacede(marriageAppServiceImpl marriageDataFacede) {
		this.marriageDataFacede = marriageDataFacede;
	}

	public List<marriage> getGrandMarriage() {
		return grandMarriage;
	}

	public void setGrandMarriage(List<marriage> grandMarriage) {
		this.grandMarriage = grandMarriage;
	}

	public List<marriage> getFatherMarriage() {
		return fatherMarriage;
	}

	public void setFatherMarriage(List<marriage> fatherMarriage) {
		this.fatherMarriage = fatherMarriage;
	}

	
	
	
}
