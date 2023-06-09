<script>
	import { querystring } from "svelte-spa-router";
	import {getApi} from '../service'
    import App from "../../App.svelte";
	import 'query-string'
	const searchParams = new URLSearchParams($querystring);
	const t = searchParams.get("id")
	// const options = {
    //     path: '/show',
    //     access_token: '',
    //   }
	// const getData = getApi(options)
	const options = {
        path: '/show?id='+t,
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
</script>

<main>
	{#await promise}
		로딩중....
	{:then data} 
	<button type="button" onclick="location.href='/'"> 뒤로</button>
	<div><span style="font-size: large ; display: inline">제목:    </span><p style="font-size: large ; display: inline">{data.title}</p></div>
	<div><span style="font-size: xx-small; display: inline">작성자:    </span><p style="font-size: xx-small; display: inline">{data.userName}</p></div>
	
	<div> <p style="font-size: medium" >{data.content}</p></div>
	{/await}
</main>
