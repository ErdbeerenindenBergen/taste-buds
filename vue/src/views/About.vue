<template>
  <div class="about-us">
    <div class="about-title">
      <h1>Meet the taste buds Team!</h1>
    </div>

    <div class="Kassi">
      <h3>Kassi Burnett</h3>
      <img class="picture" src="@/assets/Kassi.png" alt="Kassi Burnett" />
      <h5>The Leader</h5>
      <p>
        Kassi is the person we looked to in order to keep us all in line. She is
        always willing to help and could be found working late into the night or
        early morning. The true MVP of this project.<a
          class="linkedin"
          href="www.linkedin.com/in/kassi-burnett-phd"
          >Kassi's Linkedin</a
        >
      </p>
    </div>

    <div class="Brittany">
      <h3>Brittany Weaver</h3>
      <img class="big-picture" src="@/assets/Brittany.png" alt="Brittany Weaver" />
      <h5>The Rubber Ducky</h5>
      <p>
        Brittany is the person you bounce ideas off of. You can find her working
        alongside Kassi. They like to joke that they are half of each others
        brain. The stuff the accomplish together is phenomenal.<a
          class="linkedin"
          href="www.linkedin.com/in/brittanyweaver13"
          >Brittany's Linkedin</a
        >
      </p>
    </div>

    <div class="Mikey">
      <h3>Mikey Nguyen</h3>
      <img class="bigger-picture" src="@/assets/Mikey.png" alt="Mikey Nguyen" />
      <h5>The Silver Tongue</h5>
      <p>
        Mikey is quick witted and is always thinking up creative names and
        jokes. He came up with the awesome app name. He also asked that I
        include that Mikey is at that point in life, that a middle-aged man
        reaches, in which he thinks about dyson spheres once a week.<a
          class="linkedin"
          href="www.linkedin.com/in/mikey-nguyen2"
          >Mikey's Linkedin</a
        >
      </p>
    </div>

    <div class="Matthew">
      <h3>Matthew Reynolds</h3>
      <img class="bigger-picture" src="@/assets/Matthew.png" alt="Matthew Reynolds" />
      <h5>Sport Enthusiast</h5>
      <p>
        Matthew tends to be quiet. Give him an objective and he is off to the
        races and finishes his work.<a
          class="linkedin"
          href="https://www.linkedin.com/in/matthew-reynolds-jsd/"
          >Matthew's Linkedin.</a
        >
      </p>
    </div>

    <div class="Kevin">
      <h3>Kevin Apolinario</h3>
      <img class="big-picture" src="@/assets/Kevin.png" alt="Kevin Apolinario" />
      <h5>The Chef, also refers to himself as Codeman</h5>
      <p>
        Kevin makes delicious mac'n cheese, but don't ask him for his recipe he
        won't share it. Trust us, we have been asking for months.
        <a class="linkedin" href="https://www.linkedin.com/in/kapolinario/"
          >Kevin's Linkedin.</a
        >
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "about",
};
</script>

<style scoped>

h1 {
  font-size:50px;
  font-family: "Playfair Display";
  font-weight: bold;
  text-align: center;
  padding-top: 40px;
}

h3{
  font-size:45px;
  font-weight:bold;
}

.Kassi,.Brittany,.Mikey,.Matthew,.Kevin{
  display:flex;
  flex-direction:column;
  flex-wrap: wrap;
  justify-content: center;
}

.Kassi,.Mikey{
  float:left;
  width:50%;
  padding-right:25px;
}

.Kevin{
  width:100%;
}

.picture,.big-picture,.bigger-picture{
  border-radius: 100px;
  height:300px;
  justify-content: center;
  width:300px;
  margin:auto;
}

h5{
  text-align:center;
  font-size:30px;
}

p{
  font-size:25px;
  padding: 0px 45px;
}

.linkedin{
  font-size:30px;
  padding-top:30px;
  font-weight:bold;
}

a.router-link-active {
  font-weight: bold;
}
</style>