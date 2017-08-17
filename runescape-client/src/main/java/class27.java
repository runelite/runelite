import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public enum class27 implements RSEnum {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   field402(1, (byte)0),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   field408(2, (byte)1),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   field403(0, (byte)2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   field404(3, (byte)3);

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "[Lkp;"
   )
   @Export("hitmarks")
   static SpritePixels[] hitmarks;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -546226109
   )
   final int field405;
   @ObfuscatedName("g")
   final byte field406;
   @ObfuscatedName("ac")
   @Export("clientInstance")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static Client clientInstance;

   class27(int var3, byte var4) {
      this.field405 = var3;
      this.field406 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "316484705"
   )
   public int rsOrdinal() {
      return this.field406;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-510949337"
   )
   static final void method226(int var0) {
      class135.field2002[++class135.field1997 - 1] = var0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "-72753425"
   )
   static final boolean method229(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label70:
      while(true) {
         int var6 = var4.getUSmart();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.getUSmart();
               if(var9 == 0) {
                  continue label70;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = class37.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.lowMemory || var15.field3445 != 0 || var15.interactType == 1 || var15.field3430) {
                     if(!var15.method4573()) {
                        ++Client.field981;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.getUSmart();
            if(var9 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-739593089"
   )
   @Export("isIgnored")
   static boolean isIgnored(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = FloorUnderlayDefinition.method4398(var0, class22.field354);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(FloorUnderlayDefinition.method4398(var3.name, class22.field354))) {
               return true;
            }

            if(var1.equalsIgnoreCase(FloorUnderlayDefinition.method4398(var3.previousName, class22.field354))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lia;B)V",
      garbageValue = "-52"
   )
   public static void method235(IndexDataBase var0) {
      class245.field3307 = var0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "94"
   )
   public static void method234(int var0, int var1) {
      Varbit var3 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var8 = Varbit.varbit_ref.getConfigData(14, var0);
         var3 = new Varbit();
         if(var8 != null) {
            var3.decode(new Buffer(var8));
         }

         Varbit.varbits.put(var3, (long)var0);
         var2 = var3;
      }

      int var4 = var2.configId;
      int var5 = var2.leastSignificantBit;
      int var6 = var2.mostSignificantBit;
      int var7 = class212.field2602[var6 - var5];
      if(var1 < 0 || var1 > var7) {
         var1 = 0;
      }

      var7 <<= var5;
      class212.widgetSettings[var4] = class212.widgetSettings[var4] & ~var7 | var1 << var5 & var7;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BI)Lcj;",
      garbageValue = "1764921450"
   )
   static Script method233(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.payload.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.payload.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intStackCount = var2.readUnsignedShort();
      var1.stringStackCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.method1864(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            IterableHashTable var9 = new IterableHashTable(IndexFile.method3032(var8));
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.put(new IntegerNode(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var2.getNullString();
      var1.instructions = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.readString();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }
}
