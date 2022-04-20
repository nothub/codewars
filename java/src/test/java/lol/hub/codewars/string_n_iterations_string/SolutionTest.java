package lol.hub.codewars.string_n_iterations_string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void fixed1() {
        String expected = "Sc o!uhWw";
        String actual = JomoPipi.jumbledString("Such Wow!", 25);
        assertEquals(expected, actual);
    }

    @Test
    public void fixed2() {
        String expected = "bexltept merae";
        String actual = JomoPipi.jumbledString("better example", 2);
        assertEquals(expected, actual);
    }

    @Test
    public void fixed3() {
        String expected = "Gtsegenri";
        String actual = JomoPipi.jumbledString("Greetings", 8);
        assertEquals(expected, actual);
    }

    @Test
    public void python() {
        String expected = "qtorieuwy";
        String actual = JomoPipi.jumbledString("qwertyuio", 2);
        assertEquals(expected, actual);
    }

    @Test
    public void bel_air() {
        String expected = "Ndsogeo  begi be,ia sgo i,wt oyIgrnisiuafotnyI Il h adeien nn   ihs tllaai  o 'aemgar  tytsopu edf g ddle td,saiah oeoe whaldsieeep ao  wn t Apnensy nr  oy ieh itriae'cya dhepac a  ee efhac a teitYela    jlf  lspn holth'h'oedoa mta wdgapasrldhr e iai iyuoowsru   ahop om voe w h hacek   o 'gosI p'maryegse lfgsdlAt shsoetit ai es i  rhii  ihhdi y oea te r lcge lloywsho eu Ietm gg i j  ihhbea  tra adlns ig dcee t'rpuot'ate  peae   ho ik hoosce d rtt-u  e s  so mf,oe?ioodchhrIelulP  oImbgloo tdtnoepdistkklmcmaha t ennt eBakpt lskenmdt  'tat myin a drvolthrgsngt se imieeru dnmhe  h hI dohmd  dfAw intm iirlalo oh i  t e'tocngtbttae.'drtee llcwAIsoeI kanl esuah tyodse  esen r.  silhmt hB lo Snee lskt esyde itul  ihe l,aoett trptnaa hwhramcIith   ettycrsh tl t I nbe'rpelpne ao spe ib cuag tuTnebty sma ay o aapetooreslwtdang oiDodelrt uyooIo dhogSe   lndtfoey tu son  eMh urdl naae ueyt gm w ddlev IadrowdAdIrw n lehrh eimtp,e nre lhs ut aroe to ainIAb Invsg r seap sc f itwi niphgo uuooirpnheypm hhtnw tminaet  lIeePuudodehsentor?o snvtfofnnTsu h'qe tf  m rag Ihe u r ea  c ia   tbt d oaael wcu'elecd a ysltatgt mril ditay ipaayiiu-It h kcBidy i  k.aTeC tiYt nkmgo oeuw  wlFo llce  skIoomBr h A   hs csnll mhge's - ils tccicdsIosge tre rsrbikadrte,sapt  .c ebte iWga  isIhi etsxaBolf thell tkn dupp Osh't Wil   a tdyam emnaitd esin e bg e llookIW di rexaI phie o adasmauk Ibahe'weul bYer   unwi nth rnll  e ehh mtnthn ttnntiniocref jdehindh teJenadiwhBlBru t se yn  rat seo   -n p eetlhthwyfw isdBaaecratsoo ny'ynnfgh ra' ae ii u,eeinl ra r ykh mraustnoto bcleeutmaiastthI en liNg tlt ri oBe nrtaweumres,i ea l ai  tttI wtiotrHeo  n gkr eeen nlilhcaff -elord  hcf a nheniaehynilihSi'd p eses g s lepahmo  rhty n A meyeui'i n ghs' dAnon l";
        String actual = JomoPipi.jumbledString("Now, this is a story all about how My life got flipped-turned upside down And I'd like to take a minute Just sit right there I'll tell you how I became the prince of a town called Bel Air  In west Philadelphia born and raised On the playground was where I spent most of my days Chillin' out maxin' relaxin' all cool And all shootin some b-ball outside of the school When a couple of guys who were up to no good Started making trouble in my neighborhood I got in one little fight and my mom got scared She said 'You're movin' with your auntie and uncle in Bel Air'  I begged and pleaded with her day after day But she packed my suit case and sent me on my way She gave me a kiss and then she gave me my ticket. I put my Walkman on and said, 'I might as well kick it'.  First class, yo this is bad Drinking orange juice out of a champagne glass. Is this what the people of Bel-Air living like? Hmm this might be alright.  But wait I hear they're prissy, bourgeois, all that Is this the type of place that they just send this cool cat? I don't think so I'll see when I get there I hope they're prepared for the prince of Bel-Air  Well, the plane landed and when I came out There was a dude who looked like a cop standing there with my name out I ain't trying to get arrested yet I just got here I sprang with the quickness like lightning, disappeared  I whistled for a cab and when it came near The license plate said fresh and it had dice in the mirror If anything I could say that this cab was rare But I thought 'Nah, forget it' - 'Yo, homes to Bel Air' I pulled up to the house about seven or eigth  And I yelled to the cabbie 'Yo homes smell ya later' I looked at my kingdom I was finally there To sit on my throne as the Prince of Bel Air", 42);
        assertEquals(expected, actual);
    }

    @Test
    public void large_strings_large_n() {
        String expected = "";
        String actual = JomoPipi.jumbledString("", 42);
        assertEquals(expected, actual);
    }
}
