import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
@Implements("ClientParameter")
public class ClientParameter {
   @ObfuscatedName("se")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static class248 field3645;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_m")
   static final ClientParameter __ji_m;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_f")
   static final ClientParameter __ji_f;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_q")
   static final ClientParameter __ji_q;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_w")
   static final ClientParameter __ji_w;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_o")
   static final ClientParameter __ji_o;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_u")
   static final ClientParameter __ji_u;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_g")
   static final ClientParameter __ji_g;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_l")
   static final ClientParameter __ji_l;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_e")
   static final ClientParameter __ji_e;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_x")
   static final ClientParameter __ji_x;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_d")
   static final ClientParameter __ji_d;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_k")
   static final ClientParameter __ji_k;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_n")
   public static final ClientParameter __ji_n;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_i")
   public static final ClientParameter __ji_i;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_a")
   static final ClientParameter __ji_a;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_z")
   static final ClientParameter __ji_z;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_j")
   static final ClientParameter __ji_j;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_s")
   static final ClientParameter __ji_s;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("__ji_t")
   static final ClientParameter __ji_t;
   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   @Export("__ji_fp")
   static AbstractSocket __ji_fp;
   @ObfuscatedName("y")
   @Export("id")
   public final String id;

   static {
      __ji_m = new ClientParameter("8", "8");
      __ji_f = new ClientParameter("15", "15");
      __ji_q = new ClientParameter("7", "7");
      __ji_w = new ClientParameter("10", "10");
      __ji_o = new ClientParameter("16", "16");
      __ji_u = new ClientParameter("12", "12");
      __ji_g = new ClientParameter("3", "3");
      __ji_l = new ClientParameter("6", "6");
      __ji_e = new ClientParameter("17", "17");
      __ji_x = new ClientParameter("5", "5");
      __ji_d = new ClientParameter("9", "9");
      __ji_k = new ClientParameter("14", "14");
      __ji_n = new ClientParameter("18", "18");
      __ji_i = new ClientParameter("13", "13");
      __ji_a = new ClientParameter("4", "4");
      __ji_z = new ClientParameter("1", "1");
      __ji_j = new ClientParameter("11", "11");
      __ji_s = new ClientParameter("2", "2");
      __ji_t = new ClientParameter("19", "19");
   }

   ClientParameter(String var1, String var2) {
      this.id = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1723515140"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(FriendLoginUpdate.__kn_x == null) {
            FriendLoginUpdate.__kn_x = TriBool.urlRequester.request(new URL(ServerBuild.worldsUrl));
         } else if(FriendLoginUpdate.__kn_x.isDone()) {
            byte[] var0 = FriendLoginUpdate.__kn_x.getResponse();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldsCount = var1.__ag_302();
            ItemContainer.worlds = new World[World.worldsCount];

            World var3;
            for(int var2 = 0; var2 < World.worldsCount; var3.index = var2++) {
               var3 = ItemContainer.worlds[var2] = new World();
               var3.id = var1.__ag_302();
               var3.properties = var1.readInt();
               var3.host = var1.readStringCp1252NullTerminated();
               var3.activity = var1.readStringCp1252NullTerminated();
               var3.location = var1.readUnsignedByte();
               var3.population = var1.__aq_303();
            }

            MilliClock.method3400(ItemContainer.worlds, 0, ItemContainer.worlds.length - 1, World.__bt_e, World.__bt_l);
            FriendLoginUpdate.__kn_x = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         FriendLoginUpdate.__kn_x = null;
      }

      return false;
   }
}
