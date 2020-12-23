-- ----------------------------
--  Table structure for `blocks`
-- ----------------------------
DROP TABLE IF EXISTS block;

CREATE TABLE block
(
    id SERIAL PRIMARY KEY,
    block_num integer DEFAULT NULL,
    data_hash character varying(256) DEFAULT NULL,
    previous_block_hash character varying(256) DEFAULT NULL,
    tx_count integer DEFAULT NULL,
    create_time Timestamp DEFAULT NULL,
    current_block_hash character varying(256) DEFAULT NULL,
    channel_genesis_hash character varying(256) DEFAULT NULL,
    block_size integer DEFAULT NULL,
    network_name varchar(255)
);

-- ----------------------------
--  Table structure for `chaincodes`
-- ----------------------------
DROP TABLE IF EXISTS chaincode;

CREATE TABLE chaincode
(
    id SERIAL PRIMARY KEY,
    name character varying(255) DEFAULT NULL,
    version character varying(255) DEFAULT NULL,
    path character varying(255) DEFAULT NULL,
    channel_genesis_hash character varying(256) DEFAULT NULL,
    tx_count integer DEFAULT 0,
    create_time Timestamp DEFAULT NULL,
    network_name varchar(255)
);

-- ---------------------------
--  Table structure for `peer_ref_chaincode`
-- ----------------------------
DROP TABLE IF EXISTS peer_ref_chaincode;

CREATE TABLE peer_ref_chaincode
(
    id SERIAL PRIMARY KEY,
    peer_id varchar(256) DEFAULT NULL,
    chaincode_id varchar(255) DEFAULT NULL,
    chaincode_version varchar(255) DEFAULT NULL,
    channel_id character varying(256) DEFAULT NULL,
    create_time Timestamp DEFAULT NULL,
    network_name varchar(255)
);

-- ----------------------------
--  Table structure for `channel`
-- ----------------------------
DROP TABLE IF EXISTS channel;

--   state character(1) NOT NULL DEFAULT A CHECK (state in (A, D, S))

CREATE TABLE channel
(
    id SERIAL PRIMARY KEY,
    name varchar(256) DEFAULT NULL,
    block_count integer DEFAULT NULL,
    tx_count integer DEFAULT NULL,
    create_time Timestamp DEFAULT NULL,
    channel_genesis_hash character varying(256) DEFAULT NULL,
    channel_hash character varying(256) DEFAULT NULL,
    channel_config bytea default NULL,
    channel_block bytea DEFAULT NULL,
    channel_tx bytea DEFAULT NULL,
    channel_version character varying(256) DEFAULT NULL,
    network_name varchar(255)
);

-- ----------------------------
--  Table structure for `peer`
-- ----------------------------
DROP TABLE IF EXISTS peer;

--   state character(1) NOT NULL DEFAULT A CHECK (state in (A, D, S))

CREATE TABLE peer
(
    id SERIAL PRIMARY KEY,
    org integer DEFAULT NULL,
    channel_genesis_hash character varying(256) DEFAULT NULL,
    msp_id varchar(256) DEFAULT NULL,
    requests varchar(256) DEFAULT NULL,
    events varchar(256) DEFAULT NULL,
    server_hostname varchar(256) DEFAULT NULL,
    create_time timestamp DEFAULT NULL,
    peer_type character varying(256) DEFAULT NULL,
    network_name varchar(255)
);
-- ---------------------------
--  Table structure for `peer_ref_channel`
-- ----------------------------
DROP TABLE IF EXISTS peer_ref_channel;

CREATE TABLE peer_ref_channel
(
    id SERIAL PRIMARY KEY,
    create_time Timestamp DEFAULT NULL,
    peer_id varchar(256),
    channel_id character varying(256),
    peer_type character varying(256) DEFAULT NULL,
    network_name varchar(255)
);

-- ====================Orderer BE-303=====================================
-- ----------------------------
--  Table structure for `orderer`
-- ----------------------------
DROP TABLE IF EXISTS orderer;

--   state character(1) NOT NULL DEFAULT A CHECK (state in (A, D, S))

CREATE TABLE orderer
(
    id SERIAL PRIMARY KEY,
    requests varchar(256) DEFAULT NULL,
    server_hostname varchar(256) DEFAULT NULL,
    create_time timestamp DEFAULT NULL,
    network_name varchar(255)
);

--// ====================Orderer BE-303=====================================
-- ----------------------------
--  Table structure for `transactions`
-- ----------------------------
DROP TABLE IF EXISTS transaction;
CREATE TABLE transaction
(
    id SERIAL PRIMARY KEY,
    block_id integer DEFAULT NULL,
    tx_hash character varying(256) DEFAULT NULL,
    create_time timestamp DEFAULT NULL,
    chaincode_name character varying(255) DEFAULT NULL,
    status integer DEFAULT NULL,
    creator_msp_id character varying(256) DEFAULT NULL,
    endorser_msp_id character varying(800) DEFAULT NULL,
    chaincode_id character varying(256) DEFAULT NULL,
    type character varying(256) DEFAULT NULL,
    read_set json default NULL,
    write_set json default NULL,
    channel_genesis_hash character varying(256) DEFAULT NULL,
    validation_code character varying(255) DEFAULT NULL,
    envelope_signature character varying DEFAULT NULL,
    payload_extension character varying DEFAULT NULL,
    creator_id_bytes character varying DEFAULT NULL,
    creator_nonce character varying DEFAULT NULL,
    chaincode_proposal_input character varying DEFAULT NULL,
    tx_response character varying DEFAULT NULL,
    payload_proposal_hash character varying DEFAULT NULL,
    endorser_id_bytes character varying DEFAULT NULL,
    endorser_signature character varying DEFAULT NULL,
    network_name varchar(255)
);


DROP INDEX IF EXISTS blocks_blocknum_idx;
CREATE INDEX ON Block
(block_num);

DROP INDEX IF EXISTS blocks_channel_genesis_hash_idx;
CREATE INDEX ON Block
(channel_genesis_hash);

DROP INDEX IF EXISTS blocks_createdt_idx;
CREATE INDEX ON Block
(create_time);

DROP INDEX IF EXISTS transaction_txhash_idx;
CREATE INDEX ON Transaction
(tx_hash);

DROP INDEX IF EXISTS transaction_channel_genesis_hash_idx;
CREATE INDEX ON Transaction
(channel_genesis_hash);

DROP INDEX IF EXISTS transaction_createdt_idx;
CREATE INDEX ON Transaction
(create_time);

DROP INDEX IF EXISTS transaction_blockid_idx;
CREATE INDEX ON Transaction
(block_id);

DROP INDEX IF EXISTS transaction_chaincode_proposal_input_idx;
CREATE INDEX ON Transaction
((md5
(chaincode_proposal_input)));

DROP INDEX IF EXISTS channel_channel_genesis_hash_idx;
CREATE INDEX ON channel
(channel_genesis_hash);

DROP INDEX IF EXISTS channel_channel_hash_idx;
CREATE INDEX ON channel
(channel_hash);