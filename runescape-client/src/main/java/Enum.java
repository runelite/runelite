import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("EnumDefinition_indexCache")
   public static IndexDataBase EnumDefinition_indexCache;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("EnumDefinition_cached")
   static NodeCache EnumDefinition_cached;
   @ObfuscatedName("cu")
   @Export("middleMouseMovesCamera")
   static boolean middleMouseMovesCamera;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = -302781069
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("n")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("r")
   @Export("valType")
   public char valType;
   @ObfuscatedName("e")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1317294819
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -911443503
   )
   @Export("size")
   public int size;
   @ObfuscatedName("s")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("p")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("x")
   @Export("stringVals")
   public String[] stringVals;

   static {
      EnumDefinition_cached = new NodeCache(64);
   }

   Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "1268131080"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "700797113"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.keyType = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.valType = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.defaultString = var1.readString();
      } else if(var2 == 4) {
         this.defaultInt = var1.readInt();
      } else {
         int var3;
         if(var2 == 5) {
            this.size = var1.readUnsignedShort();
            this.keys = new int[this.size];
            this.stringVals = new String[this.size];

            for(var3 = 0; var3 < this.size; ++var3) {
               this.keys[var3] = var1.readInt();
               this.stringVals[var3] = var1.readString();
            }
         } else if(var2 == 6) {
            this.size = var1.readUnsignedShort();
            this.keys = new int[this.size];
            this.intVals = new int[this.size];

            for(var3 = 0; var3 < this.size; ++var3) {
               this.keys[var3] = var1.readInt();
               this.intVals[var3] = var1.readInt();
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1668405568"
   )
   public int method5067() {
      return this.size;
   }

   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class23.clientInstance.method883();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field1076 = 0;
            Client.field890 = 0;
            Client.field1077.method5319(var0);
            if(var0 != 20) {
               BaseVarType.method14(false);
            }
         }

         if(var0 != 20 && var0 != 40 && VertexNormal.field1912 != null) {
            VertexNormal.field1912.vmethod3379();
            VertexNormal.field1912 = null;
         }

         if(Client.gameState == 25) {
            Client.field909 = 0;
            Client.field1105 = 0;
            Client.field906 = 1;
            Client.field907 = 0;
            Client.field908 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class2.method7(GrandExchangeOffer.indexCache10, Renderable.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class2.method7(GrandExchangeOffer.indexCache10, Renderable.indexSprites, false, 4);
            } else {
               World.method1656();
            }
         } else {
            class2.method7(GrandExchangeOffer.indexCache10, Renderable.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }
}
