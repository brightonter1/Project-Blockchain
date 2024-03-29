const { STARTING_BALANCE } = require('../config');
const { ec } = require('../utill');
const crytoHash = require('../utill/crypto-hash')

class Wallet {

    constructor() {
        this.balance = STARTING_BALANCE;

        this.keyPair = ec.genKeyPair();

        this.publicKey = this.keyPair.getPublic().encode('hex');
    }

    sign(data) {
        return this.keyPair.sign(crytoHash(data));
    }

}

module.exports = Wallet;