const INTITIAL_DIFFICULTY = 3;
const MINE_RATE = 1000;


const GENESIS_DATA = {
    timestamp: 'xxxxx',
    lastHash: '-----',
    hash: 'genesis_hash',
    difficulty: INTITIAL_DIFFICULTY,
    nonce: 0,
    data: []
};

const STARTING_BALANCE = 1000;

module.exports = { GENESIS_DATA, MINE_RATE, STARTING_BALANCE };