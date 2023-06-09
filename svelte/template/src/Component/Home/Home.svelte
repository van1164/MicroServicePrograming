<script>
	import {getApi,postApi} from '../service'
	const options = {
        path: '',
        access_token: '',
      }
	let promise = Promise.resolve([])
	function get() {
    	return new Promise(async (resolve, reject) => {
      try {
        const res = await getApi(options)
        resolve(res)
      } catch (err) {
        console.log(err)
        reject(err)
      } finally {
        console.log('Done!')
      }
    })
  }
  promise = get()
  console.log(promise)
</script>

<main>
	<button type="button" onclick="location.href='#/write'"> 글쓰기</button>
	<table>
		<tr>
			<th>작성자</th>
			<th>제목</th>
		</tr>
{#await promise}
	<p>로딩중...</p>
{:then FormDatas} 	
{#each FormDatas as F}
		<tr>
	<td>{F.userName}</td>
	<td>{F.title}</td>
	<td><a href = '#/show?id={F.id}'>글 보기</a></td>
</tr>
{/each}
{/await}

	</table>


</main>

<style>

</style>
