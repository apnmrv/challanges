<?php
/**
 * Created by PhpStorm.
 * User: pandrey
 * Date: 30/05/2018
 * Time: 13:51
 */

namespace App\Tests\Entity;

use App\Entity\User;
use PHPUnit\Framework\TestCase;

class UserTest extends TestCase
{
    /**
     * @test
     */
    public function happyCreation()
    {
        $user = new User();

        $this->assertInstanceOf(User::class, $user );
    }

}
