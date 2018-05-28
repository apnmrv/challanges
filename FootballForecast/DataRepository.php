<?php
include_once('IDataStorage.php');

class DataRepository
{
    /**
     * @var DataStorage
     */
    private $storage;

    public function __construct(IDataStorage $storage)
    {
        $this->storage = $storage;
    }

    public function getDataPrepared(int $a, int $b) : array
    {
    	$rawDataTotal	= $this->storage->retrieveAll();
 	
    	return [
    		'paramT1'	=>	array_sum(array_column($rawDataTotal, 'games'))/2,
    		'paramT2'	=>	array_sum(array_column(array_column($rawDataTotal, 'goals'), 'scored')),
    		'paramT3'	=>	array_sum(array_column(array_column($rawDataTotal, 'goals'), 'skiped')),
    		'paramA1'	=>	$rawDataTotal[$a]['games'],
    		'paramA2'	=>	$rawDataTotal[$a]['goals']['scored'],	
    		'paramA3'	=>	$rawDataTotal[$a]['goals']['skiped'],
    		'paramB1'	=>	$rawDataTotal[$b]['games'],
    		'paramB2'	=>	$rawDataTotal[$b]['goals']['scored'],
    		'paramB3'	=>	$rawDataTotal[$b]['goals']['skiped']	
    	];
    }
}