package roots.plugin.config.gui;

public class TreeEntity
{
    private String nodeDescription;
    private NodeID nodeID;
    private String icoLeaf;

    public enum NodeID
    {
	CONFIG_LOOK_AND_FEEL
    }

    public TreeEntity(String nodeDescription, NodeID nodeID, String icoLeaf)
    {
	this.nodeDescription = nodeDescription;
	this.nodeID = nodeID;
	this.icoLeaf = icoLeaf;
    }

    public String getIcoLeaf()
    {
        return icoLeaf;
    }

    public void setIcoLeaf(String icoLeaf)
    {
        this.icoLeaf = icoLeaf;
    }

    public String getNodeDescription()
    {
	return nodeDescription;
    }

    public void setNodeDescription(String nodeDescription)
    {
	this.nodeDescription = nodeDescription;
    }

    public NodeID getNodeID()
    {
	return nodeID;
    }

    public void setNodeID(NodeID nodeID)
    {
	this.nodeID = nodeID;
    }

    public String toString()
    {
	return this.nodeDescription;
    }
}
