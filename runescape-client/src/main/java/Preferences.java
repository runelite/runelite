import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -885144123
   )
   static int field1187;
   @ObfuscatedName("o")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("p")
   @Export("muted")
   boolean muted;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 360156671
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("h")
   @Export("rememberedUsername")
   String rememberedUsername;
   @ObfuscatedName("l")
   @Export("hideUsername")
   boolean hideUsername;
   @ObfuscatedName("y")
   @Export("preferences")
   LinkedHashMap preferences;

   static {
      field1187 = 6;
   }

   Preferences() {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      this.method1692(true);
   }

   @ObfuscatedSignature(
      signature = "(Lgn;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1187) {
            if(var1.readUnsignedByte() == 1) {
               this.hideRoofs = true;
            }

            if(var2 > 1) {
               this.muted = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.screenType = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.preferences.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }

            if(var2 > 4) {
               this.rememberedUsername = var1.getNullString();
            }

            if(var2 > 5) {
               this.hideUsername = var1.method3554();
            }
         } else {
            this.method1692(true);
         }
      } else {
         this.method1692(true);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2066473357"
   )
   void method1692(boolean var1) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Lgn;",
      garbageValue = "2104606408"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1187);
      var1.putByte(this.hideRoofs?1:0);
      var1.putByte(this.muted?1:0);
      var1.putByte(this.screenType);
      var1.putByte(this.preferences.size());
      Iterator var2 = this.preferences.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putInt(((Integer)var3.getKey()).intValue());
         var1.putInt(((Integer)var3.getValue()).intValue());
      }

      var1.putString(this.rememberedUsername != null?this.rememberedUsername:"");
      var1.writeBooleanAsByte(this.hideUsername);
      return var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Ljb;",
      garbageValue = "-1302898840"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = SoundTask.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isHollow) {
            var1.clipType = 0;
            var1.blocksProjectile = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1442819963"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(World.listFetcher == null) {
            World.listFetcher = class46.urlRequester.request(new URL(class31.field407));
         } else if(World.listFetcher.isDone()) {
            byte[] var0 = World.listFetcher.getResponse();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            World.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = World.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            BoundingBox3DDrawMode.method52(World.worldList, 0, World.worldList.length - 1, World.field1166, World.field1168);
            World.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         World.listFetcher = null;
      }

      return false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lie;III)Llv;",
      garbageValue = "-47419494"
   )
   static IndexedSprite method1693(IndexDataBase var0, int var1, int var2) {
      return !class258.method4705(var0, var1, var2)?null:NameableContainer.method5288();
   }
}
