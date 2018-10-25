#!/bin/sh

git filter-branch -f --env-filter \
	"GIT_AUTHOR_NAME='qihouying'; GIT_AUTHOR_EMAIL='dream_0920@qq.com'; \
	GIT_COMMITTER_NAME='qihouying'; GIT_COMMITTER_EMAIL='qihouying@meituan.com';" HEAD
