<?php
interface IDataStorage{
	public function retrieve(int $id): array;
	public function retrieveAll(): array;
}