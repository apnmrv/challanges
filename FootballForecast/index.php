<?php
include_once('data.php');
include_once('DataStorage.php');
include_once('DataRepository.php');
include_once('Mathematician.php');

//var_dump(match(28, 15));

function match(int $c1, int $c2) : array
{
	global $data;
	$storage = new DataStorage($data);
	$repo = new DataRepository($storage);
	
	$dataPrepared = $repo->getDataPrepared($c1, $c2);
	$math = Mathematician::fromData($dataPrepared);
	
	return $math->doCalculation();
}
