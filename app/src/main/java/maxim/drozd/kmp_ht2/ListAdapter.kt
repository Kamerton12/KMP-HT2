package maxim.drozd.kmp_ht2

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.util.*
import kotlin.collections.ArrayList

class ListAdapter: RecyclerView.Adapter<ListViewHolder>() {

    private val messages = arrayOf("caci probiology meteoroid leucocytosis phonometer Gregarinina ",
    "giinwale dissaved explosible capple sensomobile ",
    "overattenuating ethnos overproness chamberleted hurroosh Chicoine ",
    "obliquenesses Glyn pseudoneuropteran ",
    "posterodorsad tripes Tironian ",
    "nuttier urare desulfurisation performative consolable ",
    "Barrios fightingly provisionary Breckinridge ancre ",
    "misarray unenigmatic modulates ",
    "untartarized tinctured Hiss uncontrasted brachistocephaly ",
    "trichomatous unflared righties daukin ",
    "phenospermy cacophonist Moesogothic incautiousness Elaeocarpaceae ",
    "ergatogyny misinstructing Harpalinae Soyinka Henka ",
    "Comitadji barfs maimers ",
    "Zarla deutoplastic monstrosities ",
    "soldierize haffat frustums eelcatcher ",
    "chg. chamberlet gromyl ",
    "trochanteral guillotinism fenland ",
    "ageneses antihumanist dye ",
    "jubileal speakingly billowiness ",
    "hypermasculine unquailing palpebration ",
    "polymorphous anticensorious Nepos engirt misfiled ",
    "chasteness merling kalsominer ",
    "theriodont bulldog's liberals hypersensuousness ",
    "unallowedly alacha xylophone precisive Honomu ",
    "Cotton grainland hyperpigmentation ",
    "loafed flatcaps Juanne Getic skullbanker ",
    "cartelistic leadier cercaria Climatius ",
    "unabashedly tummlers disentrance ovoviviparously Anderer ",
    "akvavit thermoelastic caravans Danava declassify ensealing ",
    "outpracticing Critta manganbrucite reabridge Timbuktu ",
    "setups tinglish unethic questionably ",
    "mortbell rebater philorchidaceous ",
    "Cerrillos wiseacred fossilisation ungrizzled ",
    "textile's gaur defaced ",
    "intel nonnervousness recrayed conglomerator pantechnicon tacheometry ",
    "unlucid Aretinian behoving interchain peoplement cryocautery ",
    "syncopated Wendelin Olsson ",
    "Aldhafara effetman panegyrists romanos sereins ",
    "leaner Orientalising parasexual hecastotheism Fathometer coordinators ",
    "Tho DCVO Renaldo bustards nonchalant ",
    "potshot iniquitously discern peachlet ",
    "Empson vagation Bandhor Linders bemurmured ",
    "overoptimism supersentimental goury Jellicoe ",
    "competitiveness whummle enframed arthrodic fixated ",
    "excuseless circumdenudation goelism ",
    "McCanna denotement nothingness ",
    "obvallate diacodion prereturn ",
    "equities Chloranthaceae lint overaction Fraktur ",
    "Odum cosmogonic Louellen lingua predislike Humashim ",
    "ARP acridic unsewed ",
    "Luis mirroring unifications jacals strongman buckone ",
    "SSPS wigged coiling Ammadas ",
    "cloisterless Pinzon contradictiveness predispute Senonian ",
    "blotting outbitch choruslike extraction circumlocutory ",
    "overregularity Alsea preconceived pneumonographic gaffs ",
    "nowaday twirler petro Fitchburg reawakenings whiteback ",
    "jejunities Aimo Rann Sphaeriidae ",
    "nonfelicity orthostyle Tinia kilopound nondivisive ",
    "slipcoat whammle Ursola ",
    "preemperor methoxychlor relinked irrationalize nondictatorialness ",
    "baldachin scalpers Marlborough Minnewit ",
    "ratifia synodicon athrogenic pontons ",
    "superregal splendidness carryable setback ",
    "calorimetrically anisotropal hasteful sprose Lehighton ",
    "diploidies cacks platyodont unascertainably groats ",
    "Derr inheritors callipering ",
    "hirtch Glenellyn realizableness ",
    "superobstinate superaddition Portageville ",
    "Brooklin moorhens Geibel Tarahumari stochastic ",
    "ajiva dentinasal wailful Oelwein ",
    "pascals gynaeceum concatenates underwheel ",
    "pyrographer almehs modally pepperbox ",
    "Jurane relevied Marlovian Bougainvillaea ",
    "centigrado dryinid Eglon euchysiderite ",
    "busket Ivanna swallo ",
    "ungainliness unman Amblyopsidae cannonade influenzalike ",
    "Budweiser Karakoram orthicons sulphonal ",
    "Vyernyi Succoth fondants ",
    "ungroundedness huffy QDCS carpentries vitrobasalt Aphanes ",
    "surprisers FAQL neumes sandalwood disingenious ",
    "malaxable ouananiche prechill rerub ",
    "uprend Kalama chastisers cupolaman podotheca ",
    "walth prevomer hexathlon ",
    "industrialist capsizes aconitums etiquette anticreatively checksums ",
    "lustreware Bangladesh uninvocative basics ",
    "basketlike Tagaur homoiothermic townlike waspnesting ",
    "Oakboy sissier licenser overinhibited junglegym ",
    "boyology nonexpulsive overrid ",
    "desume spareable Wyncote epiphonemas ",
    "Imperforata saccharimetrical inclasped birdseeds ",
    "toyotas Edana peribolus uncurled horsefettler PCF ",
    "phaeophycean aponogetonaceous Fischer wiseacreish ",
    "laccol coatless outwrites entocoel ",
    "contravenes Xograph quadrifid pectate sigillarian ",
    "Reteporidae hyperactivities Schechter weeded ",
    "Royden aglycone trinkets magnetoid ",
    "bowfins verticomental sussing ",
    "recoilingly desugaring covetable unreiterative ",
    "tangoed facilitates virginities ",
    "nonutile Negris jagirdar ",
    "numskullism crosslink Oilla gript oxygenant enlief ",
    "aphony merozoite helotisms ",
    "combats pursy Raybourne coapting ",
    "beldame dephlegmatory Bothriolepis forewish Thamos ",
    "scillitoxin Kati unvenged nontheosophical discouragingly ",
    "squinniest martyrological chesset guileful ",
    "zonula sciolto teenfuls timorous ",
    "imbalm sexagonal Theobroma tovarishes ",
    "mucosopurulent squirt refixation taboring ",
    "pyrologies otiant integripalliate ",
    "whitecap cyclopentadiene cinecamera futhork ",
    "curveting Struldbruggian piratic ",
    "B.D. debauchees waise ",
    "chercock skinned unbetterable Gerius autospray ",
    "gilgie Wenatchee phragma Colrain Phalan ",
    "cynophilic tasselmaker supered avunculize ",
    "kae percussion subgraphs babbishly neuroblastoma ",
    "nonprescribed OFM restiad muscaris unconstipated dette ",
    "nonextermination integraph inabstinence loftman Bryantsville ",
    "predoubtful preindemnified forehall uncaptured ",
    "geomance pyloralgia electrostriction homegoer ",
    "ppr glaucophane diether concurbit ",
    "upclimbs Calinog annexations shortcomer civilizational ",
    "polytrope approver strappable countermandable Aleksandrovsk ",
    "orthovanadic wolfward Pogonatum ",
    "Poulsbo preterrational trueblue omnimodous bitonal ",
    "deckedout pupilage that'll ",
    "beats writhedly freity oscitant ",
    "saponaceousness farthermore hutzpah reinfluencing undepraved ",
    "feods unrated epipharyngeal unsolvableness intenders ",
    "endures octants carnification ",
    "inserviceable graving Raskind ",
    "semihostile semicylindrical impressment disseisee ",
    "imposing Angelical subparty reslates ",
    "nuncles Everly archplotter transmutive beneurous ",
    "grumphies Novikoff Rosati SJD ",
    "nuncios capacitively gesticulator ",
    "foxtrots undaunted nonmagnetic Uitlander ",
    "engr greasy galyacs ",
    "Avraham Spartiate Stalinite hydrocephaloid ",
    "lends Nilson ANPA Edric frumentaceous fiercenesses ",
    "nongeneric crannied pidginization exflect ferrihemoglobin ",
    "Larochelle neatest pumpkinseed pauperized ",
    "Echinochloa infilm plagueproof egomanias ",
    "nontanning intolerantness cimicifugin handwrote ",
    "vellicated emancipatress dacryagogue ",
    "nonspored tweedledee Lamarque scissoria lauryl ",
    "Phigalian morepeon Barranquitas overfacile ",
    "pyrotoxin expressionlessness skullfish invenient ",
    "asarta undelectability furciferous clanjamfrie begass unvolatilized ",
    "wuzzer opportunists ambidexter ",
    "floorboard Cevennes pigments otherwhence ",
    "IONL unmunificent mantilla unpegs unconservatively ",
    "homophonic nonecumenical nonyielding excircle ",
    "dicarbonic nonemulously dashier lymphatolytic straightforwardly ",
    "babassu Dianil revolting portague contraparallelogram ",
    "polydispersity Praha competitory armouring ",
    "calusar skinkle renopulmonary ",
    "dinkly diacetate Karloff unblundered ",
    "hypermetrope pondfish microcrystallinity Balt. ",
    "saltus underscribe Arnuad Roz undemonstratable ",
    "electrobrasser Sclav kileh unrebuffed ",
    "pipeman inower leuchemia Fredelia condue ",
    "preachiness Ventris Arjuna lorel ",
    "oghamic unairily imprests nonstretchy ",
    "unwishfully mannoheptose knessets unbreeching ratteners ",
    "coeff unfulled angolan grotesquerie ",
    "seriffed sapwoods Hellespontus tacheture alichel ",
    "mesopodia radioautograph bloodsuckers presubscribing ",
    "electromagnetize mamaliga solanines duikerbuck lethargies ",
    "Accius uncapriciousness prigs nonuser ",
    "chatta disinherited ughten recreationist ",
    "balistarii uppercase spermatozoal Rhineura equimultiple ",
    "stencilled affiliations didactical wildings dogaressa ",
    "tribasicity misdial amyotrophic pigeonite ",
    "indentors mandibuliform discutient pipiness ",
    "playwrightess Birdie Philomachus withsay fissuration ",
    "frenate homochromosome president's ",
    "distraite polyhistorian nemertean ",
    "weft nonexultantly solonetses Abercromby ichthyotomist Huronian ",
    "severedly greenbark fluxionally oldermost Ortles ",
    "sententiarian stubbiness viragoish unbefool ",
    "philibegs photonuclear cojudices toiting stinkeroos ",
    "enjoiner abortus pregladden elevates Antennata superradicalness ",
    "envenomed Goodyera recognition's ",
    "causse justifier's bewitcher atmological ",
    "immitigability frivoller OIr ",
    "noctilucin interjoin Roseboro subparts ",
    "vitrioling orthodolichocephalic semihumanitarian Barajas ",
    "ophiuroid dissecting amphisbaenian ",
    "stipulating bibliotaphic extremest polycentral unsufficiency ",
    "counterextend sacralization Countess Dunton conjointness ",
    "remarshaling Sphaerophoraceae histoclastic romanceish ",
    "tode Caodaism sinicizes furloughed ",
    "creaght ventages acquittals undetractory overtrustfully ",
    "upchaunce paganish skeered Pulayan ",
    "reembrace Manfred unscandalised overenvious ",
    "stevedore milleporous Buceros limning poaching ",
    "sugsloot hybrids IRQ forlorner organzined ",
    "lemonado sportsome extinguishable ourari ")

    val items = ArrayList<Field?>()

    init {
        for(i in 0..999)
            items.add(null)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.list_item_layout, p0, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val r = Random()
        if(items[position] == null)
            items[position] = Field((r.nextInt(messages.size)), Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256)))
        holder.bind(messages[items[position]!!.messageIndex], position, this, items)
    }

    class Field(val messageIndex: Int, val color: Int)
}