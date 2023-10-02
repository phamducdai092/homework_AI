package chapter2.agent_ABCD;

import chapter2.agent_ABCD.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		if(p.getLocationState()==LocationState.DIRTY) {
			return new DynamicAction("SUCK");
		}else if(p.getAgentLocation().equals("A")) {
			return new DynamicAction("RIGHT");
		}else if(p.getAgentLocation().equals("B")) {
			return new DynamicAction("DOWN");
		}else if(p.getAgentLocation().equals("C")) {
			return new DynamicAction("LEFT");
		}else if(p.getAgentLocation().equals("D")) {
			return new DynamicAction("UP");
		}
		return NoOpAction.NO_OP;
		
	}
}