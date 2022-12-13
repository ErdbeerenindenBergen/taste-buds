<template>
  <div class="event-invitee-list">


    <div id="invitee-info" v-bind:invitee="invitee"  v-for="invitation in $store.state.invitees"  :key="invitation.invitationId">

      <div id="invitee-name">
        <p >{{ invitation.emailAddress }}</p>
      </div>

   
    </div>
  </div>
</template>

<script>

export default {
  name: "event-invitee",
  props: ["invitee"],
  components: {
  },
  methods: {
  
    },
  
};
</script>
