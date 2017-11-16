import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = 1116468463
   )
   static int field3448;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field3453;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field3456;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 2112759471
   )
   static int field3458;
   @ObfuscatedName("r")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("g")
   @Export("valType")
   public char valType;
   @ObfuscatedName("x")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1210123289
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1953128829
   )
   @Export("size")
   public int size;
   @ObfuscatedName("t")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("k")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("n")
   @Export("stringVals")
   public String[] stringVals;

   static {
      field3456 = new NodeCache(64);
   }

   public Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "-1085866955"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4464(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfs;II)V",
      garbageValue = "548639951"
   )
   void method4464(Buffer var1, int var2) {
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-378529997"
   )
   public static void method4462(int var0) {
      if(var0 != -1) {
         if(class56.validInterfaces[var0]) {
            TextureProvider.widgetIndex.method4113(var0);
            if(Widget.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(Widget.widgets[var0][var2] != null) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  Widget.widgets[var0] = null;
               }

               class56.validInterfaces[var0] = false;
            }
         }
      }
   }
}
