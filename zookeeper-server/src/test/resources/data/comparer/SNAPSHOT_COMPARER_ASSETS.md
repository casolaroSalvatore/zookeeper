
# SnapshotComparerTest assets

Place all files under:

```text
zookeeper-server/src/test/resources/data/comparer/
```

The JUnit4 class `SnapshotComparerTest.java` expects the following assets:

## Core assets

- `left.snap`: valid baseline ZooKeeper snapshot.
- `right_plus_1.snap`: valid snapshot with at least one path present only in the right snapshot.
- `right_identical.snap`: separate physical file with the same logical tree as `left.snap`.
- `corrupt_file.snap`: invalid file; the test creates this automatically if missing.

## Payload-delta assets

- `left_payload.snap`: valid snapshot containing a path also present in `right_payload_changed.snap`.
- `right_payload_changed.snap`: same paths as `left_payload.snap`, but at least one common path has a payload delta.
- Update `D_BYTES` in `SnapshotComparerTest.java` to match the real byte delta.

## Node-count delta assets

- `left_nodes.snap`: valid snapshot containing a common subtree.
- `right_nodes_changed.snap`: same comparable subtree, but with a known descendant-count delta.
- Update `D_NODES` in `SnapshotComparerTest.java` to match the real node/descendant delta.

## Mixed-delta assets

- `left_mixed.snap`
- `right_mixed.snap`

These should contain a mixture of added, removed, and payload-modified znodes.

## Optional compressed assets

- `left.snappy`
- `right_plus_1.gz`

The compression-format test is skipped automatically if these optional assets are missing.

## Practical generation strategy

1. Reuse existing valid ZooKeeper snapshot files where possible.
2. Generate additional snapshots by running a local ZooKeeper server, applying a controlled sequence of `zkCli` commands, and stopping the server to persist snapshots.
3. Copy the generated snapshot files into `src/test/resources/data/comparer/` and rename them according to the names above.
4. For `right_identical.snap`, copy `left.snap` byte-for-byte.
5. For `corrupt_file.snap`, no real snapshot is needed; any text file is sufficient.
