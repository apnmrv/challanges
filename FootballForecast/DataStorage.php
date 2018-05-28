<?php

include_once('IDataStorage.php');

class DataStorage implements IDataStorage
{
    /**
     * @var array
     */
    private $data = [];
    
    public function __construct(array $data){
    	$this->data = $data;
    }

    public function retrieve(int $id): array
    {
        if (!isset($this->data[$id])) {
            throw new \OutOfRangeException(sprintf('No data found for ID %d', $id));
        }
				
        return $this->data[$id];
    }
    
    public function retrieveAll(): array
    {
        return $this->data;
    }
}
