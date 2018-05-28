<?php

class Mathematician {
	
	private $eventsTotal;
	private $successTotal;
	private $failureTotal;
	
	private $eventsA;
	private $successA;
	private $failureA;
	
	private $eventsB;
	private $successB;
	private $failureB;
		
	public function __construct(	int $eTotal,
									int $sTotal,
									int $fTotal,
									int	$eA,
									int $sA,
									int $fA,	
									int	$eB,
									int $sB,
									int $fB){
		$this->eventsTotal = $eTotal;
		$this->successTotal = $sTotal;
		$this->failureTotal = $fTotal;
		$this->eventsA = $eA;
		$this->successA = $sA;
		$this->failureA = $fA;
		$this->eventsB = $eB;
		$this->successB = $sB;
		$this->failureB = $fB;	
	}
	
	static function fromData(array $data) : Mathematician {
		return new self(
			(int)$data['paramT1'],
			(int)$data['paramT2'],
			(int)$data['paramT3'],
			(int)$data['paramA1'],
			(int)$data['paramA2'],
			(int)$data['paramA3'],
			(int)$data['paramB1'],
			(int)$data['paramB2'],
			(int)$data['paramB3']
		);
	}
	
	public function doCalculation () : array {
		$expectations = $this->getExpectations();
		for ($i = 0; $i < 6; $i++) {
			$poissonA [(string)$i] = $this->getPoisson($expectations['a'], $i);
			$poissonB[(string)$i] = $this->getPoisson($expectations['b'], $i);
		}
		arsort($poissonA);
		arsort($poissonB);
		$keysA = array_keys($poissonA);
		$keysB = array_keys($poissonB);
		
		return [
					(int)$keysA[0],
					(int)$keysB[0]
				];														
	}
	
	private function getPoisson(float $m, int $num){
		return (pow($m, $num) * pow(M_E, -1*$m))/$this->getFactorial($num);
	}

	private function getFactorial(int $int){	
		$result = 1;
		for ($i = $int; $i > 1;  $i--) {
			$result *= $i;
		}		
		return $result;
	}
	
	private function getExpectations() : array
    {
		
		$successMeanTotal	= $this->successTotal / $this->eventsTotal;
		$failureMeanTotal 	= $this->failureTotal / $this->eventsTotal;
		
		$successMeanA 		= $this->successA / $this->eventsA;
		$failureMeanA 		= $this->failureA / $this->eventsA;
		
		$successMeanB 		= $this->successB / $this->eventsA;
		$failureMeanB 		= $this->failureB / $this->eventsA;
		
		$successPowerA		= $successMeanA / $successMeanTotal;
		$successPowerB		= $successMeanB / $successMeanTotal;
		
		$failurePowerA		= $failureMeanA / $failureMeanTotal;
		$failurePowerB		= $failureMeanB / $failureMeanTotal;
		
		return [
					'a'		=> $successPowerA*$failurePowerB*$successMeanTotal,
					'b'		=> $successPowerB*$failurePowerA*$successMeanTotal
		];
	}
	
}