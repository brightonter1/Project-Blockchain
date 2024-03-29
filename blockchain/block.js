const { GENESIS_DATA, MINE_RATE } = require('../config');
const cryptoHash = require('../utill/crypto-hash');
class Block {
    constructor({ timestamp, lastHash, hash, data, nonce, difficulty }) {
        this.timestamp = timestamp;
        this.lastHash = lastHash;
        this.hash = hash;
        this.data = data;
        this.nonce = nonce;
        this.difficulty = difficulty;
    }

    static genesis() {
        return new Block(GENESIS_DATA);
    }

    static mineBlock({ lastBlock, data }) {
        const lastHash = lastBlock.hash;
        let hash, timestamp;
        let { difficulty } = lastBlock;
        let nonce = 0;

        do {
            nonce++;
            timestamp = Date.now();
            difficulty = Block.adjustDifficulty({ originBlock: lastBlock, timestamp });
            hash = cryptoHash(timestamp, lastHash, data, nonce, difficulty);

        } while (hash.substring(0, difficulty) !== '0'.repeat(difficulty));

        return new this({ timestamp, lastHash, data, difficulty, nonce, hash });
    }

    static adjustDifficulty({ originBlock, timestamp }) {
        const { difficulty } = originBlock;

        const difference = timestamp - originBlock.timestamp;

        if ((timestamp - originBlock.timestamp) > MINE_RATE) return difficulty - 1;
        return difficulty + 1;
    }
}

module.exports = Block;