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
   static final ClientParameter field322;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static final ClientParameter field323;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static final ClientParameter field324;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static final ClientParameter field325;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static final ClientParameter field326;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static final ClientParameter field327;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static final ClientParameter field328;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static final ClientParameter field329;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static final ClientParameter field330;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static final ClientParameter field331;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static final ClientParameter field332;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static final ClientParameter field333;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   public static final ClientParameter field334;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   public static final ClientParameter field335;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static final ClientParameter field336;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static final ClientParameter field337;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static final ClientParameter field338;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static final ClientParameter field339;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static final ClientParameter field340;
   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   static AbstractSocket field341;
   @ObfuscatedName("y")
   @Export("id")
   public final String id;

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
         if (FriendLoginUpdate.field356 == null) {
            FriendLoginUpdate.field356 = TriBool.urlRequester.request(new URL(ServerBuild.worldsUrl));
         } else if (FriendLoginUpdate.field356.isDone()) {
            byte[] var0 = FriendLoginUpdate.field356.getResponse();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldsCount = var1.readUnsignedShort();
            ItemContainer.worlds = new World[World.worldsCount];

            World var2;
            for (int var3 = 0; var3 < World.worldsCount; var2.index = var3++) {
               var2 = ItemContainer.worlds[var3] = new World();
               var2.id = var1.readUnsignedShort();
               var2.properties = var1.readInt();
               var2.host = var1.readStringCp1252NullTerminated();
               var2.activity = var1.readStringCp1252NullTerminated();
               var2.location = var1.readUnsignedByte();
               var2.population = var1.method44();
            }

            MilliClock.method3400(ItemContainer.worlds, 0, ItemContainer.worlds.length - 1, World.sortOption1, World.sortOption2);
            FriendLoginUpdate.field356 = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         FriendLoginUpdate.field356 = null;
      }

      return false;
   }

   static {
      field322 = new ClientParameter("8", "8");
      field323 = new ClientParameter("15", "15");
      field324 = new ClientParameter("7", "7");
      field325 = new ClientParameter("10", "10");
      field326 = new ClientParameter("16", "16");
      field327 = new ClientParameter("12", "12");
      field328 = new ClientParameter("3", "3");
      field329 = new ClientParameter("6", "6");
      field330 = new ClientParameter("17", "17");
      field331 = new ClientParameter("5", "5");
      field332 = new ClientParameter("9", "9");
      field333 = new ClientParameter("14", "14");
      field334 = new ClientParameter("18", "18");
      field335 = new ClientParameter("13", "13");
      field336 = new ClientParameter("4", "4");
      field337 = new ClientParameter("1", "1");
      field338 = new ClientParameter("11", "11");
      field339 = new ClientParameter("2", "2");
      field340 = new ClientParameter("19", "19");
   }
}
