<script>
	import { querystring } from "svelte-spa-router";
	import {getApi,postApi} from '../service'
    import App from "../../App.svelte";
	const options = {
        path: '/show',
        access_token: '',
      }
    
    const handleSubmit =e =>{
    const ACTION_URL = e.target.action
    const formData = new FormData(e.target)
    const data = new URLSearchParams()
    for (let field of Array.from(formData)) {
			const [key, value] = field
			data.append(key, value)
		}
    for (const key of formData.values()) {
      console.log(key);
    }
    console.log(formData)
    const options = {
        path: '/save',
        data : formData,
        'content-type' : 'multipart/form-data'
      }
	postApi(options)
    location.href = '/'
}

</script>

<main>
  <button type="button" onclick="location.href='/'"> 뒤로</button>
    <form action="/save" method="post" enctype="multipart/form-data" on:submit|preventDefault={handleSubmit}>
        작성자 <input type="text" name="userName">
        비밀번호 <input type="password" name="password">
        <br>
        <br>
        <input type="text" name="title" placeholder="제목을 입력해주세요">
        <br>
        <br>
        <textarea name="content" placeholder="글을 작성해 주세요" style="width: 50%"></textarea>
        <br>
        <input value="저장" type="submit"/>
      </form>
      
</main>
